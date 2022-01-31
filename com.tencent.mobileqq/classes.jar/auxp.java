import com.tencent.qphone.base.util.QLog;

class auxp
  implements auzr
{
  auxp(auxo paramauxo, int[] paramArrayOfInt) {}
  
  public void a()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    urp.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (auxo.a(this.jdField_a_of_type_Auxo))
    {
      auxo.a(this.jdField_a_of_type_Auxo, true);
      auxo.a(this.jdField_a_of_type_Auxo).notifyAll();
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
      urp.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      urk.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      auxo.a(this.jdField_a_of_type_Auxo, paramInt);
      synchronized (auxo.a(this.jdField_a_of_type_Auxo))
      {
        auxo.a(this.jdField_a_of_type_Auxo, true);
        auxo.a(this.jdField_a_of_type_Auxo).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auxp
 * JD-Core Version:    0.7.0.1
 */