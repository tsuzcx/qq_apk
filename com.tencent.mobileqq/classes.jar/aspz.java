import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class aspz
  implements TbsReaderView.ReaderCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private aspy jdField_a_of_type_Aspy;
  private String jdField_a_of_type_JavaLangString;
  
  public aspz(aspt paramaspt, aspy paramaspy, Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_Aspy = paramaspy;
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
      this.jdField_a_of_type_Aspt.a(paramInteger.intValue(), this.jdField_a_of_type_Aspy);
      if (paramInteger.intValue() == 6001) {
        this.jdField_a_of_type_Aspt.a(this.jdField_a_of_type_AndroidAppActivity, paramObject1, paramObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aspy);
      }
      return;
      this.jdField_a_of_type_Aspt.a(paramObject1, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aspy);
      continue;
      a(paramObject2, "is_bar_animating", false);
      continue;
      this.jdField_a_of_type_Aspt.a(paramObject1, this.jdField_a_of_type_JavaLangString);
      continue;
      a(paramObject2, "TitleHeight", (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131299076));
      continue;
      if (this.jdField_a_of_type_Aspy != null)
      {
        if (this.jdField_a_of_type_Aspy.a()) {}
        for (int i = 0;; i = 1)
        {
          a(paramObject2, "is_bar_show", i);
          break;
        }
        if ((paramObject1 != null) && ((paramObject1 instanceof Integer)))
        {
          aspt localaspt = this.jdField_a_of_type_Aspt;
          if (((Integer)paramObject1).intValue() == 0) {}
          for (;;)
          {
            aspt.a(localaspt, false, bool);
            break;
            bool = false;
          }
          aspt.a(this.jdField_a_of_type_Aspt, false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspz
 * JD-Core Version:    0.7.0.1
 */