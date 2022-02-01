import com.tencent.qphone.base.util.QLog;

class bbkm
  implements bbmo
{
  bbkm(bbkl parambbkl, int[] paramArrayOfInt) {}
  
  public void a()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    yup.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (bbkl.a(this.jdField_a_of_type_Bbkl))
    {
      bbkl.a(this.jdField_a_of_type_Bbkl, true);
      bbkl.a(this.jdField_a_of_type_Bbkl).notifyAll();
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    String str;
    if (??? != null) {
      str = ???.getMessage();
    }
    for (;;)
    {
      yup.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      yuk.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      bbkl.a(this.jdField_a_of_type_Bbkl, paramInt);
      synchronized (bbkl.a(this.jdField_a_of_type_Bbkl))
      {
        bbkl.a(this.jdField_a_of_type_Bbkl, true);
        bbkl.a(this.jdField_a_of_type_Bbkl).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkm
 * JD-Core Version:    0.7.0.1
 */