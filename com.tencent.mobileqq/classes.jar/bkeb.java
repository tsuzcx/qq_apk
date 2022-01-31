import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class bkeb
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private TianShuAccess.AdItem jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
  private View b;
  
  public bkeb(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().findViewById(2131364774));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getLayoutInflater().inflate(2131558613, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, false);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131377833);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377828).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getColor(2131165457));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377829));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bkec(this));
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377830)).setOnClickListener(new bked(this));
  }
  
  private void b()
  {
    bjcf.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  private static void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    Object localObject1 = null;
    if (paramAdItem == null)
    {
      QLog.e("TianshuBigInsertPage", 2, "showLayer with null ");
      return;
    }
    this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
    Iterator localIterator = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    paramAdItem = null;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (TianShuAccess.MapEntry)localIterator.next();
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("image"))
      {
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        paramAdItem = (TianShuAccess.AdItem)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramAdItem;
      paramAdItem = (TianShuAccess.AdItem)localObject2;
      break;
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("url"))
      {
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        localObject1 = paramAdItem;
        paramAdItem = (TianShuAccess.AdItem)localObject2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TianshuBigInsertPage", 2, "showHongbaoLayer | imgUrl is: " + paramAdItem + " actionUrl: " + (String)localObject1);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bkee(this, (String)localObject1));
        PreloadManager.a().c(paramAdItem, new bkef(this));
      }
      else
      {
        localObject2 = paramAdItem;
        paramAdItem = (TianShuAccess.AdItem)localObject1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkeb
 * JD-Core Version:    0.7.0.1
 */