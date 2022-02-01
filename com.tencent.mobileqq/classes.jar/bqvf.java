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

public class bqvf
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private aqgi jdField_a_of_type_Aqgi;
  private bqvb jdField_a_of_type_Bqvb;
  private bqvo jdField_a_of_type_Bqvo;
  private List<bqvl> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private aqgi b;
  private aqgi c;
  private aqgi d;
  
  public bqvf(Context paramContext, bqvb parambqvb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bqvb = parambqvb;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.a();
    this.jdField_a_of_type_Int = agej.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    ascz localascz = new ascz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localascz, localascz);
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
    return localascz;
  }
  
  private bqvl a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bqvl localbqvl = (bqvl)localIterator.next();
        if ((!TextUtils.isEmpty(localbqvl.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbqvl.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbqvl.jdField_a_of_type_Int))
        {
          localbqvl.jdField_b_of_type_Int = paramInt2;
          if (localbqvl.jdField_b_of_type_Int == 1) {
            localbqvl.jdField_b_of_type_Boolean = true;
          }
          return localbqvl;
        }
      }
    }
    return null;
  }
  
  private void a(bqvk parambqvk)
  {
    if ((parambqvk == null) || (parambqvk.jdField_a_of_type_Bqvl == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambqvk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambqvk.jdField_a_of_type_Bqvl.jdField_b_of_type_Int);
    } while (parambqvk.jdField_a_of_type_Bqvl.jdField_b_of_type_Int != 1);
    parambqvk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambqvk.jdField_a_of_type_Bqvl.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (bhmi.b(paramString))
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
    this.jdField_a_of_type_Aqgi = new aqgi(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Aqgi.a();
    this.jdField_a_of_type_Aqgi.a(new bqvg(this));
    this.b = new aqgi(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bqvh(this));
    this.c = new aqgi(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bqvi(this));
    this.d = new aqgi(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bqvj(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqgi != null) {
      this.jdField_a_of_type_Aqgi.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bqvk parambqvk)
  {
    if ((parambqvk == null) || (parambqvk.jdField_a_of_type_Bqvl == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bqvl localbqvl = parambqvk.jdField_a_of_type_Bqvl;
    if ((localbqvl.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbqvl.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambqvk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbqvl.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label304:
    for (;;)
    {
      parambqvk.jdField_a_of_type_AndroidWidgetTextView.setText(localbqvl.jdField_c_of_type_JavaLangString);
      parambqvk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambqvk);
      parambqvk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambqvk);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbqvl.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambqvk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbqvl.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambqvk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbqvl.jdField_a_of_type_Int == 0) || (localbqvl.jdField_a_of_type_Int == 1000) || (localbqvl.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Aqgi.a(localbqvl.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label304;
          }
          parambqvk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbqvl.jdField_a_of_type_Int == 1)
          {
            if (localbqvl.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbqvl.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbqvl.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbqvl.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbqvl.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bqvl parambqvl)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambqvl == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambqvl);
  }
  
  public void a(bqvo parambqvo)
  {
    this.jdField_a_of_type_Bqvo = parambqvo;
  }
  
  public void a(List<bqvl> paramList)
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
      Object localObject = (bqvl)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bqvl)localObject).e)) && (TextUtils.isEmpty(((bqvl)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bqvo != null)) {
        bbgf.c(this.jdField_a_of_type_Bqvo.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bqvl)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bqvl)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bqvl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bqvl)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    bqvl localbqvl = (bqvl)getItem(paramInt);
    bqvk localbqvk;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562920, null);
      localbqvk = new bqvk(this);
      localbqvk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368212));
      localbqvk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371647));
      localbqvk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131372125));
      localbqvk.jdField_a_of_type_Bqvl = localbqvl;
      a(paramInt, localbqvk);
      paramView.setTag(localbqvk);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbqvk = (bqvk)paramView.getTag();
      localbqvk.jdField_a_of_type_Bqvl = localbqvl;
      a(paramInt, localbqvk);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof bqvk))
    {
      localObject1 = (bqvk)paramView.getTag();
      if (((bqvk)localObject1).jdField_a_of_type_Bqvl != null) {
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
        QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + ((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_b_of_type_Int);
      }
      bqvl localbqvl;
      switch (((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_b_of_type_Int)
      {
      default: 
        break;
      case 0: 
        if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718355), 0).a();
        }
        else
        {
          if (!TextUtils.isEmpty(((bqvk)localObject1).jdField_a_of_type_Bqvl.g))
          {
            localbqvl = a(((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_a_of_type_JavaLangString, ((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_a_of_type_Int, 1);
            Object localObject2;
            int i;
            if (localbqvl != null)
            {
              ((bqvk)localObject1).jdField_a_of_type_Bqvl = localbqvl;
              a((bqvk)localObject1);
              if (localbqvl.jdField_a_of_type_Boolean) {
                bpxo.a(localbqvl.e, localbqvl.f, localbqvl, bqvm.a().jdField_a_of_type_JavaLangString, bqvm.a().a());
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bqvo != null) {
                bbgf.c(this.jdField_a_of_type_Bqvo.a, localbqvl);
              }
              localObject2 = bozr.a();
              localObject1 = ((bqvk)localObject1).jdField_a_of_type_Bqvl.g;
              if (localbqvl != null) {
                break label355;
              }
              i = -1;
              ((bozr)localObject2).a((String)localObject1, i);
              localObject2 = new StringBuilder().append("【OnClick】messageType:");
              if (localbqvl != null) {
                break label364;
              }
            }
            for (localObject1 = "-1";; localObject1 = Integer.valueOf(localbqvl.jdField_a_of_type_Int))
            {
              bpam.b("SendPanelAdapter", localObject1);
              break;
              bpxo.a(localbqvl.e, localbqvl, bqvm.a().jdField_a_of_type_JavaLangString, bqvm.a().a());
              break label243;
              i = localbqvl.jdField_a_of_type_Int;
              break label282;
            }
          }
          this.jdField_a_of_type_Bqvo.a.a(49, ((bqvk)localObject1).jdField_a_of_type_Bqvl);
          this.jdField_a_of_type_Bqvo.a.d();
        }
        break;
      case 1: 
        localbqvl = a(((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_a_of_type_JavaLangString, ((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_a_of_type_Int, 0);
        if (localbqvl != null)
        {
          ((bqvk)localObject1).jdField_a_of_type_Bqvl = localbqvl;
          a((bqvk)localObject1);
          bpxo.a(localbqvl);
        }
        if (this.jdField_a_of_type_Bqvo != null) {
          bbgf.b(this.jdField_a_of_type_Bqvo.a, localbqvl);
        }
        break;
      case 2: 
        label243:
        if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718355), 0).a();
        }
        else
        {
          localbqvl = a(((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_a_of_type_JavaLangString, ((bqvk)localObject1).jdField_a_of_type_Bqvl.jdField_a_of_type_Int, 1);
          if (localbqvl != null)
          {
            ((bqvk)localObject1).jdField_a_of_type_Bqvl = localbqvl;
            a((bqvk)localObject1);
            bpxo.b(localbqvl);
          }
          if (this.jdField_a_of_type_Bqvo != null) {
            bbgf.a(this.jdField_a_of_type_Bqvo.a, localbqvl);
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
 * Qualified Name:     bqvf
 * JD-Core Version:    0.7.0.1
 */