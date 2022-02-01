import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class babj
  extends azwo
{
  public babj(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  public int a()
  {
    return 1017;
  }
  
  public String a()
  {
    return "ProfileMusicBoxComponent";
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool2 = super.a(paramazrb);
    if (aztm.a((azrb)this.b)) {
      return a(((azrb)this.b).a) | bool2;
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
    if (azri.a(((azrb)this.b).a.lCurrentStyleId)) {
      return true;
    }
    Object localObject;
    boolean bool;
    if (0 == 0)
    {
      localObject = this.jdField_a_of_type_Baea.a("map_key_music_box");
      if (localObject != null) {
        bool = true;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = new aztm(false);
        paramCard = ((aztm)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramCard.uin);
        paramCard.setTag(2131562049, localObject);
        bool = true;
      }
      for (;;)
      {
        if (paramCard.getTag(2131562049) != null) {
          ((aztm)paramCard.getTag(2131562049)).a((azrb)this.b);
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
        a((TextView)paramCard.findViewById(2131378815), null, (ImageView)paramCard.findViewById(2131368541));
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
    aztn localaztn = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localaztn != null) {
      localaztn.a(null);
    }
    this.jdField_a_of_type_Baea.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babj
 * JD-Core Version:    0.7.0.1
 */