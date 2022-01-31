import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;

class atdq
  implements ActionCallback
{
  atdq(atdh paramatdh, atdz paramatdz) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      this.jdField_a_of_type_Atdz.a(i, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdq
 * JD-Core Version:    0.7.0.1
 */