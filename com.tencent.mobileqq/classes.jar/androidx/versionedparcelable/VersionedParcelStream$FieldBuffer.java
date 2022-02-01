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
    if (j >= 65535) {}
    for (int i = 65535;; i = j)
    {
      this.mTarget.writeInt(i | k << 16);
      if (j >= 65535) {
        this.mTarget.writeInt(j);
      }
      this.mOutput.writeTo(this.mTarget);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcelStream.FieldBuffer
 * JD-Core Version:    0.7.0.1
 */