import com.tencent.qphone.base.util.QLog;

class avxk
  implements avzm
{
  avxk(avxj paramavxj, int[] paramArrayOfInt) {}
  
  public void a()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    vei.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (avxj.a(this.jdField_a_of_type_Avxj))
    {
      avxj.a(this.jdField_a_of_type_Avxj, true);
      avxj.a(this.jdField_a_of_type_Avxj).notifyAll();
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
      vei.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      ved.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      avxj.a(this.jdField_a_of_type_Avxj, paramInt);
      synchronized (avxj.a(this.jdField_a_of_type_Avxj))
      {
        avxj.a(this.jdField_a_of_type_Avxj, true);
        avxj.a(this.jdField_a_of_type_Avxj).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxk
 * JD-Core Version:    0.7.0.1
 */