import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class bagx
  extends badd
{
  public bagx(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  public int a()
  {
    return 1017;
  }
  
  public String a()
  {
    return "ProfileMusicBoxComponent";
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool2 = super.a(paramazxr);
    if (baac.a((azxr)this.b)) {
      return a(((azxr)this.b).a) | bool2;
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
    if (azxy.a(((azxr)this.b).a.lCurrentStyleId)) {
      return true;
    }
    Object localObject;
    boolean bool;
    if (0 == 0)
    {
      localObject = this.jdField_a_of_type_Baiy.a("map_key_music_box");
      if (localObject != null) {
        bool = true;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = new baac(false);
        paramCard = ((baac)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramCard.uin);
        paramCard.setTag(2131562109, localObject);
        bool = true;
      }
      for (;;)
      {
        if (paramCard.getTag(2131562109) != null) {
          ((baac)paramCard.getTag(2131562109)).a((azxr)this.b);
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
        a((TextView)paramCard.findViewById(2131378759), null, (ImageView)paramCard.findViewById(2131368360));
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
    baad localbaad = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localbaad != null) {
      localbaad.a(null);
    }
    this.jdField_a_of_type_Baiy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagx
 * JD-Core Version:    0.7.0.1
 */