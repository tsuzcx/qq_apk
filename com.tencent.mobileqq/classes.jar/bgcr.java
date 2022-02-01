import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class bgcr
  extends bgcy
{
  private long jdField_a_of_type_Long;
  private agkb jdField_a_of_type_Agkb;
  protected View.OnClickListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bgct jdField_a_of_type_Bgct;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  private LinearLayout c;
  
  public bgcr(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, agin paramagin)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bgcs(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372414));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372404));
    this.c = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372412));
    this.jdField_a_of_type_Agkb = ((agkb)paramagin);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Agkb.b();
  }
  
  private void a(bgbb parambgbb, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(parambgbb);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    Object localObject = (TextView)paramView.findViewById(2131377622);
    ((TextView)localObject).setText(parambgbb.a());
    label98:
    String str;
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131377619);
      if (!bool2) {
        break label221;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838680));
      localObject = (TextView)paramView.findViewById(2131377621);
      if ((parambgbb.c() == 0) && (!parambgbb.b())) {
        break label244;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130838000, 0, 0, 0);
      label152:
      paramView = (URLImageView)paramView.findViewById(2131377620);
      if (!bool2) {
        break label253;
      }
      paramView.setColorFilter(1996488704);
      label173:
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext;
      str = parambgbb.b();
      if (parambgbb.b() != 1) {
        break label261;
      }
    }
    for (;;)
    {
      bgil.a((Context)localObject, paramView, str, 19.0F, bool1);
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label221:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838679));
      break label98;
      label244:
      ((TextView)localObject).setVisibility(4);
      break label152;
      label253:
      paramView.setColorFilter(null);
      break label173;
      label261:
      bool1 = false;
    }
  }
  
  private void f()
  {
    bgbb localbgbb = bgbb.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getString(2131695938), "https://sola.gtimg.cn/aoi/sola/20200528211216_3ydkcWft2I.png");
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131561582, null);
    a(localbgbb, localView);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ArrayList<bgba> paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.isEmpty()))
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if (this.c.getChildCount() == 0) {
          this.jdField_a_of_type_Agkb.i();
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_b_of_type_AndroidWidgetLinearLayout == null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.c.getChildCount() == 0) {}
    for (int i = 1;; i = 0)
    {
      long l2 = 0L;
      this.jdField_a_of_type_Bgct = new bgct();
      paramArrayList = paramArrayList.iterator();
      boolean bool = false;
      int j = 1;
      for (;;)
      {
        Object localObject;
        if (paramArrayList.hasNext())
        {
          localObject = (bgba)paramArrayList.next();
          if ((localObject != null) && ((localObject instanceof bgbb))) {
            localObject = (bgbb)localObject;
          }
        }
        else
        {
          long l1;
          label782:
          for (;;)
          {
            for (;;)
            {
              try
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
                  break label782;
                }
                View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131561582, null);
                a((bgbb)localObject, localView);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
                localView.setId((int)((bgbb)localObject).b());
                this.jdField_a_of_type_Bgct.jdField_b_of_type_Int = localView.getWidth();
                if (i == 0) {
                  break label782;
                }
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
                localLayoutParams.setMargins(AIOUtils.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().getResources()), 0, 0, 0);
                localView.setLayoutParams(localLayoutParams);
                i = 0;
                if (!((bgbb)localObject).b())
                {
                  l1 = l2;
                  if (!((bgbb)localObject).c()) {}
                }
                else
                {
                  l1 = l2;
                  if (this.c.getChildCount() == 0)
                  {
                    this.jdField_a_of_type_Bgct.jdField_a_of_type_Boolean = true;
                    if (!((bgbb)localObject).c()) {
                      continue;
                    }
                    l1 = ((bgbb)localObject).c();
                    this.jdField_a_of_type_Bgct.jdField_a_of_type_Int = j;
                    this.jdField_a_of_type_Bgct.jdField_a_of_type_Long = ((bgbb)localObject).b();
                  }
                }
                if (j == 4) {
                  this.jdField_a_of_type_Bgct.jdField_b_of_type_Long = ((bgbb)localObject).b();
                }
                if (!((bgbb)localObject).c()) {
                  break label785;
                }
                ((bgbb)localObject).c(false);
                break label785;
                l1 = l2;
                if (!((bgbb)localObject).b()) {
                  continue;
                }
                l1 = l2;
                if (((bgbb)localObject).c() <= l2) {
                  continue;
                }
                l2 = ((bgbb)localObject).c();
                l1 = l2;
                if (j <= this.jdField_a_of_type_Bgct.jdField_a_of_type_Int) {
                  continue;
                }
                this.jdField_a_of_type_Bgct.jdField_a_of_type_Int = j;
                this.jdField_a_of_type_Bgct.jdField_a_of_type_Long = ((bgbb)localObject).b();
                l1 = l2;
                continue;
                this.jdField_a_of_type_Boolean = bool;
              }
              catch (OutOfMemoryError paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got OOM, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
              catch (InflateException paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got InflateException, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
              if ((bool) && (paramBoolean)) {}
              try
              {
                f();
                if (bool)
                {
                  this.jdField_a_of_type_Agkb.h();
                  if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
                  {
                    this.jdField_b_of_type_Boolean = true;
                    paramArrayList = String.valueOf(this.jdField_a_of_type_Long);
                    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramArrayList);
                    if (localObject == null) {
                      break;
                    }
                    bdla.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", paramArrayList, String.valueOf(((TroopInfo)localObject).dwGroupClassExt), "");
                  }
                  ThreadManager.getUIHandler().postDelayed(new AppShortcutBarPanel.1(this), 800L);
                  return;
                }
              }
              catch (OutOfMemoryError paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel ManageBtn got OOM, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
              catch (InflateException paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateAppShortcutPanel ManageBtn got InflateException, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
            }
            this.jdField_a_of_type_Boolean = false;
            if (this.jdField_a_of_type_Agkb == null) {
              break;
            }
            this.jdField_a_of_type_Agkb.i();
            return;
          }
          label785:
          j += 1;
          bool = true;
          l2 = l1;
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {}
    String str;
    TroopInfo localTroopInfo;
    do
    {
      return;
      str = String.valueOf(this.jdField_a_of_type_Long);
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
    } while (localTroopInfo == null);
    Rect localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
    int i = 0;
    label89:
    long l;
    if (i < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
      {
        localObject = ((View)localObject).getTag();
        if ((localObject instanceof bgbb))
        {
          localObject = (bgbb)localObject;
          if (localObject != null)
          {
            l = ((bgbb)localObject).b();
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (((Long)((Iterator)localObject).next()).longValue() != l);
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        bdla.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), str, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      i += 1;
      break label89;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcr
 * JD-Core Version:    0.7.0.1
 */