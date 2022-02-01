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

public class bpfl
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private aqcx jdField_a_of_type_Aqcx;
  private bpfh jdField_a_of_type_Bpfh;
  private bpfu jdField_a_of_type_Bpfu;
  private List<bpfr> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private aqcx b;
  private aqcx c;
  private aqcx d;
  
  public bpfl(Context paramContext, bpfh parambpfh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bpfh = parambpfh;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bheg.a();
    this.jdField_a_of_type_Int = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    asbg localasbg = new asbg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localasbg, localasbg);
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
    return localasbg;
  }
  
  private bpfr a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bpfr localbpfr = (bpfr)localIterator.next();
        if ((!TextUtils.isEmpty(localbpfr.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbpfr.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbpfr.jdField_a_of_type_Int))
        {
          localbpfr.jdField_b_of_type_Int = paramInt2;
          if (localbpfr.jdField_b_of_type_Int == 1) {
            localbpfr.jdField_b_of_type_Boolean = true;
          }
          return localbpfr;
        }
      }
    }
    return null;
  }
  
  private void a(bpfq parambpfq)
  {
    if ((parambpfq == null) || (parambpfq.jdField_a_of_type_Bpfr == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambpfq.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambpfq.jdField_a_of_type_Bpfr.jdField_b_of_type_Int);
    } while (parambpfq.jdField_a_of_type_Bpfr.jdField_b_of_type_Int != 1);
    parambpfq.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambpfq.jdField_a_of_type_Bpfr.jdField_c_of_type_Int);
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
    this.jdField_a_of_type_Aqcx = new aqcx(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Aqcx.a();
    this.jdField_a_of_type_Aqcx.a(new bpfm(this));
    this.b = new aqcx(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bpfn(this));
    this.c = new aqcx(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bpfo(this));
    this.d = new aqcx(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bpfp(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqcx != null) {
      this.jdField_a_of_type_Aqcx.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bpfq parambpfq)
  {
    if ((parambpfq == null) || (parambpfq.jdField_a_of_type_Bpfr == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bpfr localbpfr = parambpfq.jdField_a_of_type_Bpfr;
    if ((localbpfr.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbpfr.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambpfq.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbpfr.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label305:
    for (;;)
    {
      parambpfq.jdField_a_of_type_AndroidWidgetTextView.setText(localbpfr.jdField_c_of_type_JavaLangString);
      parambpfq.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambpfq);
      parambpfq.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambpfq);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbpfr.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambpfq.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbpfr.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambpfq.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbpfr.jdField_a_of_type_Int == 0) || (localbpfr.jdField_a_of_type_Int == 1000) || (localbpfr.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Aqcx.a(localbpfr.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label305;
          }
          parambpfq.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbpfr.jdField_a_of_type_Int == 1)
          {
            if (localbpfr.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbpfr.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbpfr.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbpfr.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbpfr.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bpfr parambpfr)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambpfr == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambpfr);
  }
  
  public void a(bpfu parambpfu)
  {
    this.jdField_a_of_type_Bpfu = parambpfu;
  }
  
  public void a(List<bpfr> paramList)
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
      Object localObject = (bpfr)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bpfr)localObject).e)) && (TextUtils.isEmpty(((bpfr)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bpfu != null)) {
        bbhl.c(this.jdField_a_of_type_Bpfu.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bpfr)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bpfr)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bpfr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bpfr)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    bpfr localbpfr = (bpfr)getItem(paramInt);
    bpfq localbpfq;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562870, null);
      localbpfq = new bpfq(this);
      localbpfq.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368381));
      localbpfq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371803));
      localbpfq.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131372283));
      localbpfq.jdField_a_of_type_Bpfr = localbpfr;
      a(paramInt, localbpfq);
      paramView.setTag(localbpfq);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbpfq = (bpfq)paramView.getTag();
      localbpfq.jdField_a_of_type_Bpfr = localbpfr;
      a(paramInt, localbpfq);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof bpfq))
    {
      localObject1 = (bpfq)paramView.getTag();
      if (((bpfq)localObject1).jdField_a_of_type_Bpfr != null) {
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
        QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + ((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_b_of_type_Int);
      }
      bpfr localbpfr;
      switch (((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_b_of_type_Int)
      {
      default: 
        break;
      case 0: 
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718986), 0).a();
        }
        else
        {
          if (!TextUtils.isEmpty(((bpfq)localObject1).jdField_a_of_type_Bpfr.g))
          {
            localbpfr = a(((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_a_of_type_JavaLangString, ((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_a_of_type_Int, 1);
            Object localObject2;
            int i;
            if (localbpfr != null)
            {
              ((bpfq)localObject1).jdField_a_of_type_Bpfr = localbpfr;
              a((bpfq)localObject1);
              if (localbpfr.jdField_a_of_type_Boolean) {
                boqd.a(localbpfr.e, localbpfr.f, localbpfr, bpfs.a().jdField_a_of_type_JavaLangString, bpfs.a().a());
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bpfu != null) {
                bbhl.c(this.jdField_a_of_type_Bpfu.a, localbpfr);
              }
              localObject2 = bnqm.a();
              localObject1 = ((bpfq)localObject1).jdField_a_of_type_Bpfr.g;
              if (localbpfr != null) {
                break label355;
              }
              i = -1;
              ((bnqm)localObject2).a((String)localObject1, i);
              localObject2 = new StringBuilder().append("【OnClick】messageType:");
              if (localbpfr != null) {
                break label364;
              }
            }
            for (localObject1 = "-1";; localObject1 = Integer.valueOf(localbpfr.jdField_a_of_type_Int))
            {
              bnrh.b("SendPanelAdapter", localObject1);
              break;
              boqd.a(localbpfr.e, localbpfr, bpfs.a().jdField_a_of_type_JavaLangString, bpfs.a().a());
              break label243;
              i = localbpfr.jdField_a_of_type_Int;
              break label282;
            }
          }
          this.jdField_a_of_type_Bpfu.a.a(20, ((bpfq)localObject1).jdField_a_of_type_Bpfr);
          this.jdField_a_of_type_Bpfu.a.d();
        }
        break;
      case 1: 
        localbpfr = a(((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_a_of_type_JavaLangString, ((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_a_of_type_Int, 0);
        if (localbpfr != null)
        {
          ((bpfq)localObject1).jdField_a_of_type_Bpfr = localbpfr;
          a((bpfq)localObject1);
          boqd.a(localbpfr);
        }
        if (this.jdField_a_of_type_Bpfu != null) {
          bbhl.b(this.jdField_a_of_type_Bpfu.a, localbpfr);
        }
        break;
      case 2: 
        label243:
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718986), 0).a();
        }
        else
        {
          localbpfr = a(((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_a_of_type_JavaLangString, ((bpfq)localObject1).jdField_a_of_type_Bpfr.jdField_a_of_type_Int, 1);
          if (localbpfr != null)
          {
            ((bpfq)localObject1).jdField_a_of_type_Bpfr = localbpfr;
            a((bpfq)localObject1);
            boqd.b(localbpfr);
          }
          if (this.jdField_a_of_type_Bpfu != null) {
            bbhl.a(this.jdField_a_of_type_Bpfu.a, localbpfr);
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
 * Qualified Name:     bpfl
 * JD-Core Version:    0.7.0.1
 */