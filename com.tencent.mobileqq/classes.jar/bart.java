import com.tencent.qphone.base.util.QLog;

class bart
  implements batv
{
  bart(bars parambars, int[] paramArrayOfInt) {}
  
  public void a()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    yqu.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (bars.a(this.jdField_a_of_type_Bars))
    {
      bars.a(this.jdField_a_of_type_Bars, true);
      bars.a(this.jdField_a_of_type_Bars).notifyAll();
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
      yqu.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      yqp.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      bars.a(this.jdField_a_of_type_Bars, paramInt);
      synchronized (bars.a(this.jdField_a_of_type_Bars))
      {
        bars.a(this.jdField_a_of_type_Bars, true);
        bars.a(this.jdField_a_of_type_Bars).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bart
 * JD-Core Version:    0.7.0.1
 */