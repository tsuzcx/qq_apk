import com.tencent.qphone.base.util.QLog;

class avxi
  implements avzk
{
  avxi(avxh paramavxh, int[] paramArrayOfInt) {}
  
  public void a()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    vel.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (avxh.a(this.jdField_a_of_type_Avxh))
    {
      avxh.a(this.jdField_a_of_type_Avxh, true);
      avxh.a(this.jdField_a_of_type_Avxh).notifyAll();
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
      vel.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      veg.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      avxh.a(this.jdField_a_of_type_Avxh, paramInt);
      synchronized (avxh.a(this.jdField_a_of_type_Avxh))
      {
        avxh.a(this.jdField_a_of_type_Avxh, true);
        avxh.a(this.jdField_a_of_type_Avxh).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxi
 * JD-Core Version:    0.7.0.1
 */