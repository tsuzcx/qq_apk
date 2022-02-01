package androidx.versionedparcelable;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class VersionedParcel$1
  extends ObjectInputStream
{
  VersionedParcel$1(VersionedParcel paramVersionedParcel, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
  {
    Class localClass = Class.forName(paramObjectStreamClass.getName(), false, getClass().getClassLoader());
    if (localClass != null) {
      return localClass;
    }
    return super.resolveClass(paramObjectStreamClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcel.1
 * JD-Core Version:    0.7.0.1
 */