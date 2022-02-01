import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class audp
  implements TbsReaderView.ReaderCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private audo jdField_a_of_type_Audo;
  private String jdField_a_of_type_JavaLangString;
  
  public audp(audj paramaudj, audo paramaudo, Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_Audo = paramaudo;
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
      this.jdField_a_of_type_Audj.a(paramInteger.intValue(), this.jdField_a_of_type_Audo);
      if (paramInteger.intValue() == 6001) {
        this.jdField_a_of_type_Audj.a(this.jdField_a_of_type_AndroidAppActivity, paramObject1, paramObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Audo);
      }
      return;
      this.jdField_a_of_type_Audj.a(paramObject1, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Audo);
      continue;
      a(paramObject2, "is_bar_animating", false);
      continue;
      this.jdField_a_of_type_Audj.a(paramObject1, this.jdField_a_of_type_JavaLangString);
      continue;
      a(paramObject2, "TitleHeight", (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131299011));
      continue;
      if (this.jdField_a_of_type_Audo != null)
      {
        if (this.jdField_a_of_type_Audo.a()) {}
        for (int i = 0;; i = 1)
        {
          a(paramObject2, "is_bar_show", i);
          break;
        }
        if ((paramObject1 != null) && ((paramObject1 instanceof Integer)))
        {
          audj localaudj = this.jdField_a_of_type_Audj;
          if (((Integer)paramObject1).intValue() == 0) {}
          for (;;)
          {
            audj.a(localaudj, false, bool);
            break;
            bool = false;
          }
          audj.a(this.jdField_a_of_type_Audj, false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audp
 * JD-Core Version:    0.7.0.1
 */