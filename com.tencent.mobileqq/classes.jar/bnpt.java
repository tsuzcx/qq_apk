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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class bnpt
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private aozt jdField_a_of_type_Aozt;
  private bnpp jdField_a_of_type_Bnpp;
  private bnqc jdField_a_of_type_Bnqc;
  private List<bnpz> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private aozt b;
  private aozt c;
  private aozt d;
  
  public bnpt(Context paramContext, bnpp parambnpp)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bnpp = parambnpp;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a();
    this.jdField_a_of_type_Int = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    aqww localaqww = new aqww(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localaqww, localaqww);
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
    return localaqww;
  }
  
  private bnpz a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bnpz localbnpz = (bnpz)localIterator.next();
        if ((!TextUtils.isEmpty(localbnpz.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbnpz.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbnpz.jdField_a_of_type_Int))
        {
          localbnpz.jdField_b_of_type_Int = paramInt2;
          if (localbnpz.jdField_b_of_type_Int == 1) {
            localbnpz.jdField_b_of_type_Boolean = true;
          }
          return localbnpz;
        }
      }
    }
    return null;
  }
  
  private void a(bnpy parambnpy)
  {
    if ((parambnpy == null) || (parambnpy.jdField_a_of_type_Bnpz == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambnpy.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambnpy.jdField_a_of_type_Bnpz.jdField_b_of_type_Int);
    } while (parambnpy.jdField_a_of_type_Bnpz.jdField_b_of_type_Int != 1);
    parambnpy.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambnpy.jdField_a_of_type_Bnpz.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
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
    this.jdField_a_of_type_Aozt = new aozt(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Aozt.a();
    this.jdField_a_of_type_Aozt.a(new bnpu(this));
    this.b = new aozt(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bnpv(this));
    this.c = new aozt(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bnpw(this));
    this.d = new aozt(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bnpx(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aozt != null) {
      this.jdField_a_of_type_Aozt.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bnpy parambnpy)
  {
    if ((parambnpy == null) || (parambnpy.jdField_a_of_type_Bnpz == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bnpz localbnpz = parambnpy.jdField_a_of_type_Bnpz;
    if ((localbnpz.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbnpz.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambnpy.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbnpz.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label305:
    for (;;)
    {
      parambnpy.jdField_a_of_type_AndroidWidgetTextView.setText(localbnpz.jdField_c_of_type_JavaLangString);
      parambnpy.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambnpy);
      parambnpy.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambnpy);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbnpz.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambnpy.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbnpz.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambnpy.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbnpz.jdField_a_of_type_Int == 0) || (localbnpz.jdField_a_of_type_Int == 1000) || (localbnpz.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Aozt.a(localbnpz.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label305;
          }
          parambnpy.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbnpz.jdField_a_of_type_Int == 1)
          {
            if (localbnpz.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbnpz.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbnpz.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbnpz.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbnpz.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bnpz parambnpz)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambnpz == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambnpz);
  }
  
  public void a(bnqc parambnqc)
  {
    this.jdField_a_of_type_Bnqc = parambnqc;
  }
  
  public void a(List<bnpz> paramList)
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
      Object localObject = (bnpz)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bnpz)localObject).e)) && (TextUtils.isEmpty(((bnpz)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bnqc != null)) {
        babc.c(this.jdField_a_of_type_Bnqc.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bnpz)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bnpz)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bnpz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bnpz)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    bnpz localbnpz = (bnpz)getItem(paramInt);
    bnpy localbnpy;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562799, null);
      localbnpy = new bnpy(this);
      localbnpy.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368236));
      localbnpy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371615));
      localbnpy.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131372090));
      localbnpy.jdField_a_of_type_Bnpz = localbnpz;
      a(paramInt, localbnpy);
      paramView.setTag(localbnpy);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbnpy = (bnpy)paramView.getTag();
      localbnpy.jdField_a_of_type_Bnpz = localbnpz;
      a(paramInt, localbnpy);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof bnpy))
    {
      localObject1 = (bnpy)paramView.getTag();
      if (((bnpy)localObject1).jdField_a_of_type_Bnpz != null) {
        break label48;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + ((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_b_of_type_Int);
      }
      bnpz localbnpz;
      switch (((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_b_of_type_Int)
      {
      default: 
        break;
      case 0: 
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718597), 0).a();
        }
        else
        {
          if (!TextUtils.isEmpty(((bnpy)localObject1).jdField_a_of_type_Bnpz.g))
          {
            localbnpz = a(((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_a_of_type_JavaLangString, ((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_a_of_type_Int, 1);
            Object localObject2;
            int i;
            if (localbnpz != null)
            {
              ((bnpy)localObject1).jdField_a_of_type_Bnpz = localbnpz;
              a((bnpy)localObject1);
              if (localbnpz.jdField_a_of_type_Boolean) {
                bnal.a(localbnpz.e, localbnpz.f, localbnpz, bnqa.a().jdField_a_of_type_JavaLangString, bnqa.a().a());
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bnqc != null) {
                babc.c(this.jdField_a_of_type_Bnqc.a, localbnpz);
              }
              localObject2 = bmbc.a();
              localObject1 = ((bnpy)localObject1).jdField_a_of_type_Bnpz.g;
              if (localbnpz != null) {
                break label355;
              }
              i = -1;
              ((bmbc)localObject2).a((String)localObject1, i);
              localObject2 = new StringBuilder().append("【OnClick】messageType:");
              if (localbnpz != null) {
                break label364;
              }
            }
            for (localObject1 = "-1";; localObject1 = Integer.valueOf(localbnpz.jdField_a_of_type_Int))
            {
              bmbx.b("SendPanelAdapter", localObject1);
              break;
              bnal.a(localbnpz.e, localbnpz, bnqa.a().jdField_a_of_type_JavaLangString, bnqa.a().a());
              break label243;
              i = localbnpz.jdField_a_of_type_Int;
              break label282;
            }
          }
          this.jdField_a_of_type_Bnqc.a.a(20, ((bnpy)localObject1).jdField_a_of_type_Bnpz);
          this.jdField_a_of_type_Bnqc.a.d();
        }
        break;
      case 1: 
        localbnpz = a(((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_a_of_type_JavaLangString, ((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_a_of_type_Int, 0);
        if (localbnpz != null)
        {
          ((bnpy)localObject1).jdField_a_of_type_Bnpz = localbnpz;
          a((bnpy)localObject1);
          bnal.a(localbnpz);
        }
        if (this.jdField_a_of_type_Bnqc != null) {
          babc.b(this.jdField_a_of_type_Bnqc.a, localbnpz);
        }
        break;
      case 2: 
        label243:
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718597), 0).a();
        }
        else
        {
          localbnpz = a(((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_a_of_type_JavaLangString, ((bnpy)localObject1).jdField_a_of_type_Bnpz.jdField_a_of_type_Int, 1);
          if (localbnpz != null)
          {
            ((bnpy)localObject1).jdField_a_of_type_Bnpz = localbnpz;
            a((bnpy)localObject1);
            bnal.b(localbnpz);
          }
          if (this.jdField_a_of_type_Bnqc != null) {
            babc.a(this.jdField_a_of_type_Bnqc.a, localbnpz);
          }
        }
        label282:
        label355:
        label364:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpt
 * JD-Core Version:    0.7.0.1
 */