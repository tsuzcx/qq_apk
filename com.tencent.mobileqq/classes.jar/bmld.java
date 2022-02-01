import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class bmld
  extends aqco
  implements bkzd
{
  public static float c = 112.0F;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private bmle jdField_a_of_type_Bmle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TianShuAccess.AdItem jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
  private String jdField_a_of_type_JavaLangString;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public bmld(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838382);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ARMapHongBaoListView))) {
      ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).setPendantHolder(null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem != null)) {
      bmkw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 122, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
    }
  }
  
  private void g()
  {
    bmkw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 4004);
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ARMapHongBaoListView)))
    {
      ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).setPendantHolder(null);
      ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).setOnPendentClickListener(null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem != null)) {
      bmkw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 102, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
    }
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public RectF a(int paramInt)
  {
    float f = -AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.f - f, this.g - f - paramInt, this.f + this.h + f, f + (this.g + this.i) - paramInt);
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    try
    {
      int j = this.jdField_a_of_type_AndroidViewView.getWidth();
      int i = j;
      if (j == 0) {
        i = ScreenUtil.SCREEN_WIDTH;
      }
      j = AIOUtils.dp2px(160.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(i - j - 0, 0, j, AIOUtils.dp2px(c, this.jdField_a_of_type_AndroidViewView.getResources()), this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.f + j - AIOUtils.dp2px(23.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.g + AIOUtils.dp2px(22.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.f + j - AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.g + AIOUtils.dp2px(37.0F, this.jdField_a_of_type_AndroidViewView.getResources()));
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(this.f + j - AIOUtils.dp2px(23.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.g, j + this.f, this.g + AIOUtils.dp2px(37.0F, this.jdField_a_of_type_AndroidViewView.getResources()));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_b_of_type_AndroidGraphicsRect != null) && (this.jdField_b_of_type_AndroidGraphicsRect.contains((int)paramFloat1, (int)paramFloat2)))
    {
      f();
      return;
    }
    g();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  protected void a(Canvas paramCanvas) {}
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {
      QLog.e("TianshuPendantHolder", 2, "showLayer with null ");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
        this.jdField_a_of_type_JavaLangString = null;
        Object localObject = paramAdItem.argList.get().iterator();
        paramAdItem = null;
        if (((Iterator)localObject).hasNext())
        {
          TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
          if (localMapEntry.key.get().equals("image")) {
            paramAdItem = localMapEntry.value.get();
          }
          for (;;)
          {
            break;
            if (localMapEntry.key.get().equals("url")) {
              this.jdField_a_of_type_JavaLangString = localMapEntry.value.get();
            }
          }
        }
        if ((TextUtils.isEmpty(paramAdItem)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          break;
        }
        localObject = URLDrawableHelper.TRANSPARENT;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngURLDrawable(paramAdItem, new int[] { 2 }, (Drawable)localObject, null, null);
      } while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null);
      this.jdField_a_of_type_Bmle = new bmle(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null));
    bmkw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
    return;
    QLog.e("TianshuPendantHolder", 1, "setpendantres error with image url " + paramAdItem + " jumpUrl " + this.jdField_a_of_type_JavaLangString);
  }
  
  protected void b(Canvas paramCanvas)
  {
    super.b(paramCanvas);
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramCanvas.save();
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void e()
  {
    try
    {
      h();
      if (QLog.isColorLevel()) {
        QLog.i("TianshuPendantHolder", 2, "stopAnimation...");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmld
 * JD-Core Version:    0.7.0.1
 */