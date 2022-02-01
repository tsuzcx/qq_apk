import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class azoh
  extends azkr
{
  public azoh(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  public int a()
  {
    return 1017;
  }
  
  public String a()
  {
    return "ProfileMusicBoxComponent";
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool2 = super.a(paramazfe);
    if (azhq.a((azfe)this.b)) {
      return a(((azfe)this.b).a) | bool2;
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
    if (azfl.a(((azfe)this.b).a.lCurrentStyleId)) {
      return true;
    }
    Object localObject;
    boolean bool;
    if (0 == 0)
    {
      localObject = this.jdField_a_of_type_Azqi.a("map_key_music_box");
      if (localObject != null) {
        bool = true;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = new azhq(false);
        paramCard = ((azhq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramCard.uin);
        paramCard.setTag(2131562069, localObject);
        bool = true;
      }
      for (;;)
      {
        if (paramCard.getTag(2131562069) != null) {
          ((azhq)paramCard.getTag(2131562069)).a((azfe)this.b);
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
        a((TextView)paramCard.findViewById(2131378600), null, (ImageView)paramCard.findViewById(2131368286));
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
    azhr localazhr = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localazhr != null) {
      localazhr.a(null);
    }
    this.jdField_a_of_type_Azqi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azoh
 * JD-Core Version:    0.7.0.1
 */