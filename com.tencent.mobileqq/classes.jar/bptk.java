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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class bptk
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private apss jdField_a_of_type_Apss;
  private bptg jdField_a_of_type_Bptg;
  private bptt jdField_a_of_type_Bptt;
  private List<bptq> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private apss b;
  private apss c;
  private apss d;
  
  public bptk(Context paramContext, bptg parambptg)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bptg = parambptg;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bgmo.a();
    this.jdField_a_of_type_Int = afur.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    arnj localarnj = new arnj(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localarnj, localarnj);
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
    return localarnj;
  }
  
  private bptq a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bptq localbptq = (bptq)localIterator.next();
        if ((!TextUtils.isEmpty(localbptq.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbptq.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbptq.jdField_a_of_type_Int))
        {
          localbptq.jdField_b_of_type_Int = paramInt2;
          if (localbptq.jdField_b_of_type_Int == 1) {
            localbptq.jdField_b_of_type_Boolean = true;
          }
          return localbptq;
        }
      }
    }
    return null;
  }
  
  private void a(bptp parambptp)
  {
    if ((parambptp == null) || (parambptp.jdField_a_of_type_Bptq == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambptp.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambptp.jdField_a_of_type_Bptq.jdField_b_of_type_Int);
    } while (parambptp.jdField_a_of_type_Bptq.jdField_b_of_type_Int != 1);
    parambptp.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambptp.jdField_a_of_type_Bptq.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (bgmg.b(paramString))
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
    this.jdField_a_of_type_Apss = new apss(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Apss.a();
    this.jdField_a_of_type_Apss.a(new bptl(this));
    this.b = new apss(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bptm(this));
    this.c = new apss(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bptn(this));
    this.d = new apss(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bpto(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apss != null) {
      this.jdField_a_of_type_Apss.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bptp parambptp)
  {
    if ((parambptp == null) || (parambptp.jdField_a_of_type_Bptq == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bptq localbptq = parambptp.jdField_a_of_type_Bptq;
    if ((localbptq.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbptq.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambptp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbptq.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label304:
    for (;;)
    {
      parambptp.jdField_a_of_type_AndroidWidgetTextView.setText(localbptq.jdField_c_of_type_JavaLangString);
      parambptp.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambptp);
      parambptp.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambptp);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbptq.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambptp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbptq.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambptp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbptq.jdField_a_of_type_Int == 0) || (localbptq.jdField_a_of_type_Int == 1000) || (localbptq.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Apss.a(localbptq.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label304;
          }
          parambptp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbptq.jdField_a_of_type_Int == 1)
          {
            if (localbptq.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbptq.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbptq.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbptq.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbptq.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bptq parambptq)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambptq == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambptq);
  }
  
  public void a(bptt parambptt)
  {
    this.jdField_a_of_type_Bptt = parambptt;
  }
  
  public void a(List<bptq> paramList)
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
      Object localObject = (bptq)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bptq)localObject).e)) && (TextUtils.isEmpty(((bptq)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bptt != null)) {
        banm.c(this.jdField_a_of_type_Bptt.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bptq)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bptq)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bptq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bptq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    bptq localbptq = (bptq)getItem(paramInt);
    bptp localbptp;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562886, null);
      localbptp = new bptp(this);
      localbptp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368138));
      localbptp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371539));
      localbptp.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131372011));
      localbptp.jdField_a_of_type_Bptq = localbptq;
      a(paramInt, localbptp);
      paramView.setTag(localbptp);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbptp = (bptp)paramView.getTag();
      localbptp.jdField_a_of_type_Bptq = localbptq;
      a(paramInt, localbptp);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof bptp))
    {
      localObject1 = (bptp)paramView.getTag();
      if (((bptp)localObject1).jdField_a_of_type_Bptq != null) {
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
        QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + ((bptp)localObject1).jdField_a_of_type_Bptq.jdField_b_of_type_Int);
      }
      bptq localbptq;
      switch (((bptp)localObject1).jdField_a_of_type_Bptq.jdField_b_of_type_Int)
      {
      default: 
        break;
      case 0: 
        if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718220), 0).a();
        }
        else
        {
          if (!TextUtils.isEmpty(((bptp)localObject1).jdField_a_of_type_Bptq.g))
          {
            localbptq = a(((bptp)localObject1).jdField_a_of_type_Bptq.jdField_a_of_type_JavaLangString, ((bptp)localObject1).jdField_a_of_type_Bptq.jdField_a_of_type_Int, 1);
            Object localObject2;
            int i;
            if (localbptq != null)
            {
              ((bptp)localObject1).jdField_a_of_type_Bptq = localbptq;
              a((bptp)localObject1);
              if (localbptq.jdField_a_of_type_Boolean) {
                bovt.a(localbptq.e, localbptq.f, localbptq, bptr.a().jdField_a_of_type_JavaLangString, bptr.a().a());
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bptt != null) {
                banm.c(this.jdField_a_of_type_Bptt.a, localbptq);
              }
              localObject2 = bnyh.a();
              localObject1 = ((bptp)localObject1).jdField_a_of_type_Bptq.g;
              if (localbptq != null) {
                break label355;
              }
              i = -1;
              ((bnyh)localObject2).a((String)localObject1, i);
              localObject2 = new StringBuilder().append("【OnClick】messageType:");
              if (localbptq != null) {
                break label364;
              }
            }
            for (localObject1 = "-1";; localObject1 = Integer.valueOf(localbptq.jdField_a_of_type_Int))
            {
              bnzb.b("SendPanelAdapter", localObject1);
              break;
              bovt.a(localbptq.e, localbptq, bptr.a().jdField_a_of_type_JavaLangString, bptr.a().a());
              break label243;
              i = localbptq.jdField_a_of_type_Int;
              break label282;
            }
          }
          this.jdField_a_of_type_Bptt.a.a(49, ((bptp)localObject1).jdField_a_of_type_Bptq);
          this.jdField_a_of_type_Bptt.a.d();
        }
        break;
      case 1: 
        localbptq = a(((bptp)localObject1).jdField_a_of_type_Bptq.jdField_a_of_type_JavaLangString, ((bptp)localObject1).jdField_a_of_type_Bptq.jdField_a_of_type_Int, 0);
        if (localbptq != null)
        {
          ((bptp)localObject1).jdField_a_of_type_Bptq = localbptq;
          a((bptp)localObject1);
          bovt.a(localbptq);
        }
        if (this.jdField_a_of_type_Bptt != null) {
          banm.b(this.jdField_a_of_type_Bptt.a, localbptq);
        }
        break;
      case 2: 
        label243:
        if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718220), 0).a();
        }
        else
        {
          localbptq = a(((bptp)localObject1).jdField_a_of_type_Bptq.jdField_a_of_type_JavaLangString, ((bptp)localObject1).jdField_a_of_type_Bptq.jdField_a_of_type_Int, 1);
          if (localbptq != null)
          {
            ((bptp)localObject1).jdField_a_of_type_Bptq = localbptq;
            a((bptp)localObject1);
            bovt.b(localbptq);
          }
          if (this.jdField_a_of_type_Bptt != null) {
            banm.a(this.jdField_a_of_type_Bptt.a, localbptq);
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
 * Qualified Name:     bptk
 * JD-Core Version:    0.7.0.1
 */