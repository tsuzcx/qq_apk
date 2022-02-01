package androidx.versionedparcelable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

class VersionedParcelStream$FieldBuffer
{
  final DataOutputStream mDataStream = new DataOutputStream(this.mOutput);
  private final int mFieldId;
  final ByteArrayOutputStream mOutput = new ByteArrayOutputStream();
  private final DataOutputStream mTarget;
  
  VersionedParcelStream$FieldBuffer(int paramInt, DataOutputStream paramDataOutputStream)
  {
    this.mFieldId = paramInt;
    this.mTarget = paramDataOutputStream;
  }
  
  void flushField()
  {
    this.mDataStream.flush();
    int j = this.mOutput.size();
    int k = this.mFieldId;
    int i;
    if (j >= 65535) {
      i = 65535;
    } else {
      i = j;
    }
    this.mTarget.writeInt(k << 16 | i);
    if (j >= 65535) {
      this.mTarget.writeInt(j);
    }
    this.mOutput.writeTo(this.mTarget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcelStream.FieldBuffer
 * JD-Core Version:    0.7.0.1
 */