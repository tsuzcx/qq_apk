import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;

class aqom
  implements ActionCallback
{
  aqom(aqod paramaqod, aqov paramaqov) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      this.jdField_a_of_type_Aqov.a(i, "");
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqom
 * JD-Core Version:    0.7.0.1
 */