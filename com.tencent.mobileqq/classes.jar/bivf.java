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

public class bivf
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private alis jdField_a_of_type_Alis;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bivb jdField_a_of_type_Bivb;
  private bivo jdField_a_of_type_Bivo;
  private List<bivl> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private alis b;
  private alis c;
  private alis d;
  
  public bivf(Context paramContext, bivb parambivb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bivb = parambivb;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bacm.a();
    this.jdField_a_of_type_Int = aciy.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    amym localamym = new amym(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localamym, localamym);
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
    return localamym;
  }
  
  private bivl a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bivl localbivl = (bivl)localIterator.next();
        if ((!TextUtils.isEmpty(localbivl.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbivl.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbivl.jdField_a_of_type_Int))
        {
          localbivl.jdField_b_of_type_Int = paramInt2;
          if (localbivl.jdField_b_of_type_Int == 1) {
            localbivl.jdField_b_of_type_Boolean = true;
          }
          return localbivl;
        }
      }
    }
    return null;
  }
  
  private void a(bivk parambivk)
  {
    if ((parambivk == null) || (parambivk.jdField_a_of_type_Bivl == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambivk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambivk.jdField_a_of_type_Bivl.jdField_b_of_type_Int);
    } while (parambivk.jdField_a_of_type_Bivl.jdField_b_of_type_Int != 1);
    parambivk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambivk.jdField_a_of_type_Bivl.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (bace.b(paramString))
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
    this.jdField_a_of_type_Alis = new alis(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Alis.a();
    this.jdField_a_of_type_Alis.a(new bivg(this));
    this.b = new alis(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bivh(this));
    this.c = new alis(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bivi(this));
    this.d = new alis(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bivj(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alis != null) {
      this.jdField_a_of_type_Alis.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bivk parambivk)
  {
    if ((parambivk == null) || (parambivk.jdField_a_of_type_Bivl == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bivl localbivl = parambivk.jdField_a_of_type_Bivl;
    if ((localbivl.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbivl.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambivk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbivl.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label304:
    for (;;)
    {
      parambivk.jdField_a_of_type_AndroidWidgetTextView.setText(localbivl.jdField_c_of_type_JavaLangString);
      parambivk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambivk);
      parambivk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambivk);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbivl.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambivk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbivl.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambivk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbivl.jdField_a_of_type_Int == 0) || (localbivl.jdField_a_of_type_Int == 1000) || (localbivl.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Alis.a(localbivl.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label304;
          }
          parambivk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbivl.jdField_a_of_type_Int == 1)
          {
            if (localbivl.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbivl.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbivl.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbivl.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbivl.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bivl parambivl)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambivl == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambivl);
  }
  
  public void a(bivo parambivo)
  {
    this.jdField_a_of_type_Bivo = parambivo;
  }
  
  public void a(List<bivl> paramList)
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
      Object localObject = (bivl)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bivl)localObject).e)) && (TextUtils.isEmpty(((bivl)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bivo != null)) {
        auts.c(this.jdField_a_of_type_Bivo.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bivl)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bivl)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bivl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bivl)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    paramViewGroup = (bivl)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496827, null);
      localbivk = new bivk(this);
      localbivk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131302061));
      localbivk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304981));
      localbivk.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131305416));
      localbivk.jdField_a_of_type_Bivl = paramViewGroup;
      a(paramInt, localbivk);
      paramView.setTag(localbivk);
      return paramView;
    }
    bivk localbivk = (bivk)paramView.getTag();
    localbivk.jdField_a_of_type_Bivl = paramViewGroup;
    a(paramInt, localbivk);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bivk))
    {
      paramView = (bivk)paramView.getTag();
      if (paramView.jdField_a_of_type_Bivl != null) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    label41:
    bivl localbivl;
    label255:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + paramView.jdField_a_of_type_Bivl.jdField_b_of_type_Int);
        }
        switch (paramView.jdField_a_of_type_Bivl.jdField_b_of_type_Int)
        {
        default: 
          return;
        case 0: 
          if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
          {
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131653894), 0).a();
            return;
          }
          if (!TextUtils.isEmpty(paramView.jdField_a_of_type_Bivl.g))
          {
            localbivl = a(paramView.jdField_a_of_type_Bivl.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bivl.jdField_a_of_type_Int, 1);
            Object localObject;
            int i;
            if (localbivl != null)
            {
              paramView.jdField_a_of_type_Bivl = localbivl;
              a(paramView);
              if (localbivl.jdField_a_of_type_Boolean) {
                bhrl.a(localbivl.e, localbivl.f, localbivl, bivm.a().jdField_a_of_type_JavaLangString);
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bivo != null) {
                auts.c(this.jdField_a_of_type_Bivo.a, localbivl);
              }
              localObject = bhci.a();
              paramView = paramView.jdField_a_of_type_Bivl.g;
              if (localbivl != null) {
                break label318;
              }
              i = -1;
              ((bhci)localObject).a(paramView, i);
              localObject = new StringBuilder().append("【OnClick】messageType:");
              if (localbivl != null) {
                break label326;
              }
            }
            for (paramView = "-1";; paramView = Integer.valueOf(localbivl.jdField_a_of_type_Int))
            {
              bhcs.a("SendPanelAdapter", 1, paramView);
              return;
              bhrl.a(localbivl.e, localbivl, bivm.a().jdField_a_of_type_JavaLangString);
              break;
              i = localbivl.jdField_a_of_type_Int;
              break label255;
            }
          }
          this.jdField_a_of_type_Bivo.a.a(49, paramView.jdField_a_of_type_Bivl);
          this.jdField_a_of_type_Bivo.a.d();
          return;
        case 1: 
          localbivl = a(paramView.jdField_a_of_type_Bivl.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bivl.jdField_a_of_type_Int, 0);
          if (localbivl != null)
          {
            paramView.jdField_a_of_type_Bivl = localbivl;
            a(paramView);
            bhrl.a(localbivl);
          }
          break;
        }
      } while (this.jdField_a_of_type_Bivo == null);
      auts.b(this.jdField_a_of_type_Bivo.a, localbivl);
      return;
      if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131653894), 0).a();
        return;
      }
      localbivl = a(paramView.jdField_a_of_type_Bivl.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bivl.jdField_a_of_type_Int, 1);
      if (localbivl != null)
      {
        paramView.jdField_a_of_type_Bivl = localbivl;
        a(paramView);
        bhrl.b(localbivl);
      }
    } while (this.jdField_a_of_type_Bivo == null);
    label318:
    label326:
    auts.a(this.jdField_a_of_type_Bivo.a, localbivl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivf
 * JD-Core Version:    0.7.0.1
 */