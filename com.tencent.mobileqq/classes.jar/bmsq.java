import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.ad.AnimationDrawableProxyView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class bmsq
  extends apsj
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AnimationDrawableProxyView jdField_a_of_type_CooperationVipAdAnimationDrawableProxyView;
  private TianShuAccess.AdItem jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
  
  public bmsq(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    try
    {
      int j = this.jdField_a_of_type_AndroidViewView.getWidth();
      int i = j;
      if (j == 0) {
        i = bclx.a;
      }
      j = afur.a(375.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(i - j - 0, 0, j, afur.a(30.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ConvActivePendantHolderBase", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {
      QLog.e("ConvActivePendantHolderBase", 2, "showLayer with null ");
    }
    label33:
    label203:
    label204:
    for (;;)
    {
      return;
      this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
      Object localObject1 = paramAdItem.argList.get().iterator();
      paramAdItem = null;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
        if (!((TianShuAccess.MapEntry)localObject2).key.get().equals("image")) {
          break label203;
        }
        paramAdItem = ((TianShuAccess.MapEntry)localObject2).value.get();
      }
      for (;;)
      {
        break label33;
        if (TextUtils.isEmpty(paramAdItem)) {
          break label204;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_loop", 1);
        localObject2 = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngURLDrawable(paramAdItem, new int[] { 2 }, (Drawable)localObject2, (Bundle)localObject1, null);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break;
        }
        this.jdField_a_of_type_CooperationVipAdAnimationDrawableProxyView = new AnimationDrawableProxyView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        a();
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null)) {
          break;
        }
        bmsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
        return;
      }
    }
  }
  
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem != null))
    {
      bmsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 102, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
      if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ARMapHongBaoListView))) {
        ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsq
 * JD-Core Version:    0.7.0.1
 */