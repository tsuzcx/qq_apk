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
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class bklr
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private alxg jdField_a_of_type_Alxg;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bkln jdField_a_of_type_Bkln;
  private bkma jdField_a_of_type_Bkma;
  private List<bklx> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private alxg b;
  private alxg c;
  private alxg d;
  
  public bklr(Context paramContext, bkln parambkln)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkln = parambkln;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bbdr.a();
    this.jdField_a_of_type_Int = actn.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    anou localanou = new anou(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localanou, localanou);
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
    return localanou;
  }
  
  private bklx a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bklx localbklx = (bklx)localIterator.next();
        if ((!TextUtils.isEmpty(localbklx.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbklx.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbklx.jdField_a_of_type_Int))
        {
          localbklx.jdField_b_of_type_Int = paramInt2;
          if (localbklx.jdField_b_of_type_Int == 1) {
            localbklx.jdField_b_of_type_Boolean = true;
          }
          return localbklx;
        }
      }
    }
    return null;
  }
  
  private void a(bklw parambklw)
  {
    if ((parambklw == null) || (parambklw.jdField_a_of_type_Bklx == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambklw.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambklw.jdField_a_of_type_Bklx.jdField_b_of_type_Int);
    } while (parambklw.jdField_a_of_type_Bklx.jdField_b_of_type_Int != 1);
    parambklw.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambklw.jdField_a_of_type_Bklx.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (bbdj.b(paramString))
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
    this.jdField_a_of_type_Alxg = new alxg(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Alxg.a();
    this.jdField_a_of_type_Alxg.a(new bkls(this));
    this.b = new alxg(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bklt(this));
    this.c = new alxg(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bklu(this));
    this.d = new alxg(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bklv(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alxg != null) {
      this.jdField_a_of_type_Alxg.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bklw parambklw)
  {
    if ((parambklw == null) || (parambklw.jdField_a_of_type_Bklx == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bklx localbklx = parambklw.jdField_a_of_type_Bklx;
    if ((localbklx.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbklx.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambklw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbklx.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label304:
    for (;;)
    {
      parambklw.jdField_a_of_type_AndroidWidgetTextView.setText(localbklx.jdField_c_of_type_JavaLangString);
      parambklw.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambklw);
      parambklw.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambklw);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbklx.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambklw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbklx.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambklw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbklx.jdField_a_of_type_Int == 0) || (localbklx.jdField_a_of_type_Int == 1000) || (localbklx.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Alxg.a(localbklx.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label304;
          }
          parambklw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbklx.jdField_a_of_type_Int == 1)
          {
            if (localbklx.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbklx.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbklx.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbklx.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbklx.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bklx parambklx)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambklx == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambklx);
  }
  
  public void a(bkma parambkma)
  {
    this.jdField_a_of_type_Bkma = parambkma;
  }
  
  public void a(List<bklx> paramList)
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
      Object localObject = (bklx)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bklx)localObject).e)) && (TextUtils.isEmpty(((bklx)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bkma != null)) {
        avtb.c(this.jdField_a_of_type_Bkma.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bklx)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bklx)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bklx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bklx)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    paramViewGroup = (bklx)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562427, null);
      localbklw = new bklw(this);
      localbklw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367679));
      localbklw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370647));
      localbklw.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131371109));
      localbklw.jdField_a_of_type_Bklx = paramViewGroup;
      a(paramInt, localbklw);
      paramView.setTag(localbklw);
      return paramView;
    }
    bklw localbklw = (bklw)paramView.getTag();
    localbklw.jdField_a_of_type_Bklx = paramViewGroup;
    a(paramInt, localbklw);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bklw))
    {
      paramView = (bklw)paramView.getTag();
      if (paramView.jdField_a_of_type_Bklx != null) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    label41:
    bklx localbklx;
    label255:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + paramView.jdField_a_of_type_Bklx.jdField_b_of_type_Int);
        }
        switch (paramView.jdField_a_of_type_Bklx.jdField_b_of_type_Int)
        {
        default: 
          return;
        case 0: 
          if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
          {
            bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719778), 0).a();
            return;
          }
          if (!TextUtils.isEmpty(paramView.jdField_a_of_type_Bklx.g))
          {
            localbklx = a(paramView.jdField_a_of_type_Bklx.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bklx.jdField_a_of_type_Int, 1);
            Object localObject;
            int i;
            if (localbklx != null)
            {
              paramView.jdField_a_of_type_Bklx = localbklx;
              a(paramView);
              if (localbklx.jdField_a_of_type_Boolean) {
                bjmd.a(localbklx.e, localbklx.f, localbklx, bkly.a().jdField_a_of_type_JavaLangString);
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bkma != null) {
                avtb.c(this.jdField_a_of_type_Bkma.a, localbklx);
              }
              localObject = bizc.a();
              paramView = paramView.jdField_a_of_type_Bklx.g;
              if (localbklx != null) {
                break label317;
              }
              i = -1;
              ((bizc)localObject).a(paramView, i);
              localObject = new StringBuilder().append("【OnClick】messageType:");
              if (localbklx != null) {
                break label325;
              }
            }
            for (paramView = "-1";; paramView = Integer.valueOf(localbklx.jdField_a_of_type_Int))
            {
              bizq.b("SendPanelAdapter", paramView);
              return;
              bjmd.a(localbklx.e, localbklx, bkly.a().jdField_a_of_type_JavaLangString);
              break;
              i = localbklx.jdField_a_of_type_Int;
              break label255;
            }
          }
          this.jdField_a_of_type_Bkma.a.a(49, paramView.jdField_a_of_type_Bklx);
          this.jdField_a_of_type_Bkma.a.d();
          return;
        case 1: 
          localbklx = a(paramView.jdField_a_of_type_Bklx.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bklx.jdField_a_of_type_Int, 0);
          if (localbklx != null)
          {
            paramView.jdField_a_of_type_Bklx = localbklx;
            a(paramView);
            bjmd.a(localbklx);
          }
          break;
        }
      } while (this.jdField_a_of_type_Bkma == null);
      avtb.b(this.jdField_a_of_type_Bkma.a, localbklx);
      return;
      if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719778), 0).a();
        return;
      }
      localbklx = a(paramView.jdField_a_of_type_Bklx.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bklx.jdField_a_of_type_Int, 1);
      if (localbklx != null)
      {
        paramView.jdField_a_of_type_Bklx = localbklx;
        a(paramView);
        bjmd.b(localbklx);
      }
    } while (this.jdField_a_of_type_Bkma == null);
    label317:
    label325:
    avtb.a(this.jdField_a_of_type_Bkma.a, localbklx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklr
 * JD-Core Version:    0.7.0.1
 */