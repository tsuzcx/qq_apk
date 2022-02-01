import com.tencent.qphone.base.util.QLog;

class bbkw
  implements bbmy
{
  bbkw(bbkv parambbkv, int[] paramArrayOfInt) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    String str;
    if (??? != null) {
      str = ???.getMessage();
    }
    for (;;)
    {
      ykv.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      ykq.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      bbkv.a(this.jdField_a_of_type_Bbkv, paramInt);
      synchronized (bbkv.a(this.jdField_a_of_type_Bbkv))
      {
        bbkv.a(this.jdField_a_of_type_Bbkv, true);
        bbkv.a(this.jdField_a_of_type_Bbkv).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    ykv.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (bbkv.a(this.jdField_a_of_type_Bbkv))
    {
      bbkv.a(this.jdField_a_of_type_Bbkv, true);
      bbkv.a(this.jdField_a_of_type_Bbkv).notifyAll();
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkw
 * JD-Core Version:    0.7.0.1
 */