import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class aywo
  extends ayrs
{
  public aywo(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  public int a()
  {
    return 1017;
  }
  
  public String a()
  {
    return "ProfileMusicBoxComponent";
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool2 = super.a(paramaymg);
    if (ayor.a((aymg)this.b)) {
      return a(((aymg)this.b).a) | bool2;
    }
    if (this.jdField_a_of_type_JavaLangObject != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_JavaLangObject = null;
      return bool1 | bool2;
    }
  }
  
  public boolean a(Card paramCard)
  {
    if (aymn.a(((aymg)this.b).a.lCurrentStyleId)) {
      return true;
    }
    Object localObject;
    boolean bool;
    if (0 == 0)
    {
      localObject = this.jdField_a_of_type_Ayyp.a("map_key_music_box");
      if (localObject != null) {
        bool = true;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = new ayor(false);
        paramCard = ((ayor)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramCard.uin);
        paramCard.setTag(2131561984, localObject);
        bool = true;
      }
      for (;;)
      {
        if (paramCard.getTag(2131561984) != null) {
          ((ayor)paramCard.getTag(2131561984)).a((aymg)this.b);
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
        a((TextView)paramCard.findViewById(2131378524), null, (ImageView)paramCard.findViewById(2131368384));
        return bool;
        paramCard = (Card)localObject;
      }
      bool = false;
      continue;
      localObject = null;
      bool = false;
    }
  }
  
  public String a_()
  {
    return "map_key_music_box";
  }
  
  public void f()
  {
    super.f();
    ayos localayos = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localayos != null) {
      localayos.a(null);
    }
    this.jdField_a_of_type_Ayyp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywo
 * JD-Core Version:    0.7.0.1
 */