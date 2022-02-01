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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class bflv
  extends bfmc
{
  private long jdField_a_of_type_Long;
  private agne jdField_a_of_type_Agne;
  protected View.OnClickListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bflx jdField_a_of_type_Bflx;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  private LinearLayout c;
  
  public bflv(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, agma paramagma)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bflw(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372143));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372134));
    this.c = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372141));
    this.jdField_a_of_type_Agne = ((agne)paramagma);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Agne.b();
  }
  
  private void a(bfkm parambfkm, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(parambfkm);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131377427);
    ((TextView)localObject).setText(parambfkm.a());
    label98:
    String str;
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131377424);
      if (!bool2) {
        break label221;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838626));
      localObject = (TextView)paramView.findViewById(2131377426);
      if ((parambfkm.b() == 0) && (!parambfkm.a())) {
        break label244;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130837954, 0, 0, 0);
      label152:
      paramView = (URLImageView)paramView.findViewById(2131377425);
      if (!bool2) {
        break label253;
      }
      paramView.setColorFilter(1996488704);
      label173:
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
      str = parambfkm.b();
      if (parambfkm.a() != 1) {
        break label261;
      }
    }
    for (;;)
    {
      bfqq.a((Context)localObject, paramView, str, 19.0F, bool1);
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label221:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838625));
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
  
  private void e()
  {
    bfkm localbfkm = bfkm.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695504), "https://sola.gtimg.cn/aoi/sola/20200528211216_3ydkcWft2I.png");
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561599, null);
    a(localbfkm, localView);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ArrayList<bfkl> paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    label438:
    label479:
    do
    {
      for (;;)
      {
        return;
        if ((paramArrayList == null) || (paramArrayList.isEmpty()))
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
          if (this.c.getChildCount() == 0) {
            this.jdField_a_of_type_Agne.h();
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
          if (this.c.getChildCount() == 0) {}
          boolean bool;
          Object localObject;
          for (int i = 1;; i = 0)
          {
            long l2 = 0L;
            this.jdField_a_of_type_Bflx = new bflx();
            paramArrayList = paramArrayList.iterator();
            bool = false;
            int k = 1;
            int j = i;
            i = k;
            while (paramArrayList.hasNext())
            {
              localObject = (bfkl)paramArrayList.next();
              if ((localObject != null) && ((localObject instanceof bfkm))) {
                localObject = (bfkm)localObject;
              }
              try
              {
                View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561599, null);
                a((bfkm)localObject, localView);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
                localView.setId((int)((bfkm)localObject).c());
                this.jdField_a_of_type_Bflx.jdField_b_of_type_Int = localView.getWidth();
                k = j;
                if (j != 0)
                {
                  LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
                  localLayoutParams.setMargins(afur.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources()), 0, 0, 0);
                  localView.setLayoutParams(localLayoutParams);
                  k = 0;
                }
                bool = true;
                long l1 = l2;
                if (((bfkm)localObject).a())
                {
                  l1 = l2;
                  if (this.c.getChildCount() == 0)
                  {
                    this.jdField_a_of_type_Bflx.jdField_a_of_type_Boolean = true;
                    l1 = l2;
                    if (((bfkm)localObject).d() > l2)
                    {
                      l2 = ((bfkm)localObject).d();
                      l1 = l2;
                      if (i > this.jdField_a_of_type_Bflx.jdField_a_of_type_Int)
                      {
                        this.jdField_a_of_type_Bflx.jdField_a_of_type_Int = i;
                        this.jdField_a_of_type_Bflx.jdField_a_of_type_Long = ((bfkm)localObject).c();
                        l1 = l2;
                      }
                    }
                  }
                }
                if (i == 4) {
                  this.jdField_a_of_type_Bflx.jdField_b_of_type_Long = ((bfkm)localObject).c();
                }
                i += 1;
                j = k;
                l2 = l1;
              }
              catch (OutOfMemoryError paramArrayList)
              {
                if (!QLog.isColorLevel()) {
                  break label438;
                }
                QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got OOM, e:" + paramArrayList.getMessage());
                System.gc();
                return;
              }
              catch (InflateException paramArrayList)
              {
                if (!QLog.isColorLevel()) {
                  break label479;
                }
                QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got InflateException, e:" + paramArrayList.getMessage());
                System.gc();
                return;
              }
            }
          }
          this.jdField_a_of_type_Boolean = bool;
          if ((bool) && (paramBoolean)) {}
          try
          {
            e();
            if (bool)
            {
              this.jdField_a_of_type_Agne.g();
              if (!this.jdField_b_of_type_Boolean)
              {
                this.jdField_b_of_type_Boolean = true;
                paramArrayList = String.valueOf(this.jdField_a_of_type_Long);
                localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramArrayList);
                if (localObject == null) {
                  continue;
                }
                bcst.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", paramArrayList, String.valueOf(((TroopInfo)localObject).dwGroupClassExt), "");
              }
              ThreadManager.getUIHandler().postDelayed(new AppShortcutBarPanel.1(this), 800L);
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
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_Agne == null);
    this.jdField_a_of_type_Agne.h();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    String str;
    TroopInfo localTroopInfo;
    do
    {
      return;
      str = String.valueOf(this.jdField_a_of_type_Long);
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str);
    } while (localTroopInfo == null);
    Rect localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
    int i = 0;
    label88:
    long l;
    if (i < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
      {
        localObject = ((View)localObject).getTag();
        if ((localObject instanceof bfkm))
        {
          localObject = (bfkm)localObject;
          if (localObject != null)
          {
            l = ((bfkm)localObject).c();
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
        bcst.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), str, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      i += 1;
      break label88;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflv
 * JD-Core Version:    0.7.0.1
 */