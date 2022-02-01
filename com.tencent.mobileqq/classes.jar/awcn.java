import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;

class awcn
  implements ActionCallback
{
  awcn(awcc paramawcc, awcx paramawcx) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      this.jdField_a_of_type_Awcx.a(i, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcn
 * JD-Core Version:    0.7.0.1
 */