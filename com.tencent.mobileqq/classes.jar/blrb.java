import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class blrb
{
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
  private ObjectOutputStream jdField_a_of_type_JavaIoObjectOutputStream = new ObjectOutputStream(this.jdField_a_of_type_JavaIoByteArrayOutputStream);
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaIoObjectOutputStream.writeInt(paramInt);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaIoObjectOutputStream.writeObject(paramObject);
  }
  
  public void a(String paramString)
  {
    a(paramString, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      this.jdField_a_of_type_JavaIoObjectOutputStream.writeUTF(paramString2);
      return;
    }
    this.jdField_a_of_type_JavaIoObjectOutputStream.writeUTF(paramString1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaIoObjectOutputStream.writeBoolean(paramBoolean);
  }
  
  public byte[] a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoObjectOutputStream.close();
      try
      {
        label7:
        arrayOfByte1 = this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            byte[] arrayOfByte1;
            this.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
            return arrayOfByte1;
          }
          catch (Exception localException3)
          {
            byte[] arrayOfByte2;
            return arrayOfByte2;
          }
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.qqwalletmsg", 2, "flushDataAndCloseStream toByteArray Exception", localException1);
          }
          arrayOfByte2 = null;
        }
      }
    }
    catch (Exception localException2)
    {
      break label7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrb
 * JD-Core Version:    0.7.0.1
 */