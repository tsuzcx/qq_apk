import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class bmxs
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private anoe jdField_a_of_type_Anoe;
  private bmxo jdField_a_of_type_Bmxo;
  private bmyb jdField_a_of_type_Bmyb;
  private List<bmxy> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private anoe b;
  private anoe c;
  private anoe d;
  
  public bmxs(Context paramContext, bmxo parambmxo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmxo = parambmxo;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bdda.a();
    this.jdField_a_of_type_Int = aekt.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    apgg localapgg = new apgg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localapgg, localapgg);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelAdapter", 2, "getIconDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localapgg;
  }
  
  private bmxy a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bmxy localbmxy = (bmxy)localIterator.next();
        if ((!TextUtils.isEmpty(localbmxy.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbmxy.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbmxy.jdField_a_of_type_Int))
        {
          localbmxy.jdField_b_of_type_Int = paramInt2;
          if (localbmxy.jdField_b_of_type_Int == 1) {
            localbmxy.jdField_b_of_type_Boolean = true;
          }
          return localbmxy;
        }
      }
    }
    return null;
  }
  
  private void a(bmxx parambmxx)
  {
    if ((parambmxx == null) || (parambmxx.jdField_a_of_type_Bmxy == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambmxx.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambmxx.jdField_a_of_type_Bmxy.jdField_b_of_type_Int);
    } while (parambmxx.jdField_a_of_type_Bmxy.jdField_b_of_type_Int != 1);
    parambmxx.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambmxx.jdField_a_of_type_Bmxy.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (bdcs.b(paramString))
    {
      paramString = ShortVideoUtils.a(paramString);
      if (paramString == null) {
        break label57;
      }
      paramString = a(paramString.toString(), paramInt1, paramInt2);
      if ((paramString instanceof URLDrawable)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
      }
      paramRecentDynamicAvatarView.setImageDrawable(paramString);
    }
    label57:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SendPanelAdapter", 2, "url  is null ");
  }
  
  private void c()
  {
    this.jdField_a_of_type_Anoe = new anoe(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Anoe.a();
    this.jdField_a_of_type_Anoe.a(new bmxt(this));
    this.b = new anoe(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bmxu(this));
    this.c = new anoe(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bmxv(this));
    this.d = new anoe(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bmxw(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anoe != null) {
      this.jdField_a_of_type_Anoe.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bmxx parambmxx)
  {
    if ((parambmxx == null) || (parambmxx.jdField_a_of_type_Bmxy == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bmxy localbmxy = parambmxx.jdField_a_of_type_Bmxy;
    if ((localbmxy.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbmxy.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambmxx.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbmxy.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label304:
    for (;;)
    {
      parambmxx.jdField_a_of_type_AndroidWidgetTextView.setText(localbmxy.jdField_c_of_type_JavaLangString);
      parambmxx.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambmxx);
      parambmxx.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambmxx);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbmxy.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambmxx.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbmxy.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambmxx.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbmxy.jdField_a_of_type_Int == 0) || (localbmxy.jdField_a_of_type_Int == 1000) || (localbmxy.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Anoe.a(localbmxy.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label304;
          }
          parambmxx.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbmxy.jdField_a_of_type_Int == 1)
          {
            if (localbmxy.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbmxy.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbmxy.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbmxy.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbmxy.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bmxy parambmxy)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambmxy == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambmxy);
  }
  
  public void a(bmyb parambmyb)
  {
    this.jdField_a_of_type_Bmyb = parambmyb;
  }
  
  public void a(List<bmxy> paramList)
  {
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "setData list is empty");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (!paramList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPanelAdapter", 2, "setData do not need refresh");
    return;
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "onEditUpdate");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Object localObject = (bmxy)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bmxy)localObject).e)) && (TextUtils.isEmpty(((bmxy)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bmyb != null)) {
        axlc.c(this.jdField_a_of_type_Bmyb.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bmxy)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bmxy)this.jdField_a_of_type_JavaUtilList.get(0)).e);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (bmxy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bmxy)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "getItemId exception = " + localException.getMessage());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (bmxy)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562630, null);
      localbmxx = new bmxx(this);
      localbmxx.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367808));
      localbmxx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370958));
      localbmxx.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131371422));
      localbmxx.jdField_a_of_type_Bmxy = paramViewGroup;
      a(paramInt, localbmxx);
      paramView.setTag(localbmxx);
      return paramView;
    }
    bmxx localbmxx = (bmxx)paramView.getTag();
    localbmxx.jdField_a_of_type_Bmxy = paramViewGroup;
    a(paramInt, localbmxx);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bmxx))
    {
      paramView = (bmxx)paramView.getTag();
      if (paramView.jdField_a_of_type_Bmxy != null) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    label41:
    bmxy localbmxy;
    label261:
    label329:
    label337:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + paramView.jdField_a_of_type_Bmxy.jdField_b_of_type_Int);
        }
        switch (paramView.jdField_a_of_type_Bmxy.jdField_b_of_type_Int)
        {
        default: 
          return;
        case 0: 
          if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131720315), 0).a();
            return;
          }
          if (!TextUtils.isEmpty(paramView.jdField_a_of_type_Bmxy.g))
          {
            localbmxy = a(paramView.jdField_a_of_type_Bmxy.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bmxy.jdField_a_of_type_Int, 1);
            Object localObject;
            int i;
            if (localbmxy != null)
            {
              paramView.jdField_a_of_type_Bmxy = localbmxy;
              a(paramView);
              if (localbmxy.jdField_a_of_type_Boolean) {
                blyd.a(localbmxy.e, localbmxy.f, localbmxy, bmxz.a().jdField_a_of_type_JavaLangString, bmxz.a().a());
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bmyb != null) {
                axlc.c(this.jdField_a_of_type_Bmyb.a, localbmxy);
              }
              localObject = blen.a();
              paramView = paramView.jdField_a_of_type_Bmxy.g;
              if (localbmxy != null) {
                break label329;
              }
              i = -1;
              ((blen)localObject).a(paramView, i);
              localObject = new StringBuilder().append("【OnClick】messageType:");
              if (localbmxy != null) {
                break label337;
              }
            }
            for (paramView = "-1";; paramView = Integer.valueOf(localbmxy.jdField_a_of_type_Int))
            {
              blfg.b("SendPanelAdapter", paramView);
              return;
              blyd.a(localbmxy.e, localbmxy, bmxz.a().jdField_a_of_type_JavaLangString, bmxz.a().a());
              break;
              i = localbmxy.jdField_a_of_type_Int;
              break label261;
            }
          }
          this.jdField_a_of_type_Bmyb.a.a(49, paramView.jdField_a_of_type_Bmxy);
          this.jdField_a_of_type_Bmyb.a.d();
          return;
        case 1: 
          localbmxy = a(paramView.jdField_a_of_type_Bmxy.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bmxy.jdField_a_of_type_Int, 0);
          if (localbmxy != null)
          {
            paramView.jdField_a_of_type_Bmxy = localbmxy;
            a(paramView);
            blyd.a(localbmxy);
          }
          break;
        }
      } while (this.jdField_a_of_type_Bmyb == null);
      axlc.b(this.jdField_a_of_type_Bmyb.a, localbmxy);
      return;
      if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131720315), 0).a();
        return;
      }
      localbmxy = a(paramView.jdField_a_of_type_Bmxy.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bmxy.jdField_a_of_type_Int, 1);
      if (localbmxy != null)
      {
        paramView.jdField_a_of_type_Bmxy = localbmxy;
        a(paramView);
        blyd.b(localbmxy);
      }
    } while (this.jdField_a_of_type_Bmyb == null);
    axlc.a(this.jdField_a_of_type_Bmyb.a, localbmxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxs
 * JD-Core Version:    0.7.0.1
 */