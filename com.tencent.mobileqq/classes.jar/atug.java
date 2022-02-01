import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class atug
  implements TbsReaderView.ReaderCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private atuf jdField_a_of_type_Atuf;
  private String jdField_a_of_type_JavaLangString;
  
  public atug(atua paramatua, atuf paramatuf, Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_Atuf = paramatuf;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(Object paramObject, String paramString, int paramInt)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle))) {
      return;
    }
    ((Bundle)paramObject).putInt(paramString, paramInt);
  }
  
  public void a(Object paramObject, String paramString, boolean paramBoolean)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle))) {
      return;
    }
    ((Bundle)paramObject).putBoolean(paramString, paramBoolean);
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Atua.a(paramInteger.intValue(), this.jdField_a_of_type_Atuf);
      if (paramInteger.intValue() == 6001) {
        this.jdField_a_of_type_Atua.a(this.jdField_a_of_type_AndroidAppActivity, paramObject1, paramObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atuf);
      }
      return;
      this.jdField_a_of_type_Atua.a(paramObject1, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Atuf);
      continue;
      a(paramObject2, "is_bar_animating", false);
      continue;
      this.jdField_a_of_type_Atua.a(paramObject1, this.jdField_a_of_type_JavaLangString);
      continue;
      a(paramObject2, "TitleHeight", (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131299080));
      continue;
      if (this.jdField_a_of_type_Atuf != null)
      {
        if (this.jdField_a_of_type_Atuf.a()) {}
        for (int i = 0;; i = 1)
        {
          a(paramObject2, "is_bar_show", i);
          break;
        }
        if ((paramObject1 != null) && ((paramObject1 instanceof Integer)))
        {
          atua localatua = this.jdField_a_of_type_Atua;
          if (((Integer)paramObject1).intValue() == 0) {}
          for (;;)
          {
            atua.a(localatua, false, bool);
            break;
            bool = false;
          }
          atua.a(this.jdField_a_of_type_Atua, false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atug
 * JD-Core Version:    0.7.0.1
 */