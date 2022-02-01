import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.ApolloBrickPlayer.1;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class amlm
{
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public int a;
  public amvg a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public CMSAction a;
  public MessageForApollo a;
  private Map<String, URLDrawable.URLDrawableOptions> jdField_a_of_type_JavaUtilMap = new HashMap();
  public int b;
  private ImageView b;
  private int c = -1;
  
  public amlm(amnc paramamnc)
  {
    a(paramamnc);
  }
  
  private void a(amnc paramamnc)
  {
    if (paramamnc != null)
    {
      this.jdField_a_of_type_Int = paramamnc.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramamnc.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidContentContext = paramamnc.jdField_a_of_type_AndroidContentContext.getApplicationContext();
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    this.jdField_a_of_type_Amvg = new amvg(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    paramamnc = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramamnc);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838049);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    int i = ViewUtils.dpToPx(70.0F);
    paramamnc = new RelativeLayout.LayoutParams(i, i);
    paramamnc.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramamnc);
  }
  
  private static URLDrawable b(String paramString, Map<String, URLDrawable.URLDrawableOptions> paramMap)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseApngImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    URLDrawable localURLDrawable = URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
    if (paramMap != null) {
      paramMap.put(paramString, localURLDrawableOptions);
    }
    return localURLDrawable;
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amvg != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      ThreadManager.excute(new ApolloBrickPlayer.1(this), 16, null, false);
    }
  }
  
  public void a(CMSAction paramCMSAction)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
    this.c = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.c();
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = new amvm(paramMessageForApollo);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage != null)) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.id;
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
        URLDrawable.removeMemoryCacheByUrl((String)localEntry.getKey(), (URLDrawable.URLDrawableOptions)localEntry.getValue());
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlm
 * JD-Core Version:    0.7.0.1
 */