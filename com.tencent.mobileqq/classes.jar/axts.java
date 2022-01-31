import com.tencent.qphone.base.util.QLog;

class axts
  implements axvu
{
  axts(axtr paramaxtr, int[] paramArrayOfInt) {}
  
  public void a()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    wxj.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (axtr.a(this.jdField_a_of_type_Axtr))
    {
      axtr.a(this.jdField_a_of_type_Axtr, true);
      axtr.a(this.jdField_a_of_type_Axtr).notifyAll();
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
      wxj.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      wxe.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      axtr.a(this.jdField_a_of_type_Axtr, paramInt);
      synchronized (axtr.a(this.jdField_a_of_type_Axtr))
      {
        axtr.a(this.jdField_a_of_type_Axtr, true);
        axtr.a(this.jdField_a_of_type_Axtr).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axts
 * JD-Core Version:    0.7.0.1
 */