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

public class bkmi
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private alxf jdField_a_of_type_Alxf;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bkme jdField_a_of_type_Bkme;
  private bkmr jdField_a_of_type_Bkmr;
  private List<bkmo> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private alxf b;
  private alxf c;
  private alxf d;
  
  public bkmi(Context paramContext, bkme parambkme)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkme = parambkme;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bbef.a();
    this.jdField_a_of_type_Int = actj.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    anoz localanoz = new anoz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localanoz, localanoz);
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
    return localanoz;
  }
  
  private bkmo a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bkmo localbkmo = (bkmo)localIterator.next();
        if ((!TextUtils.isEmpty(localbkmo.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbkmo.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbkmo.jdField_a_of_type_Int))
        {
          localbkmo.jdField_b_of_type_Int = paramInt2;
          if (localbkmo.jdField_b_of_type_Int == 1) {
            localbkmo.jdField_b_of_type_Boolean = true;
          }
          return localbkmo;
        }
      }
    }
    return null;
  }
  
  private void a(bkmn parambkmn)
  {
    if ((parambkmn == null) || (parambkmn.jdField_a_of_type_Bkmo == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambkmn.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambkmn.jdField_a_of_type_Bkmo.jdField_b_of_type_Int);
    } while (parambkmn.jdField_a_of_type_Bkmo.jdField_b_of_type_Int != 1);
    parambkmn.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambkmn.jdField_a_of_type_Bkmo.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (bbdx.b(paramString))
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
    this.jdField_a_of_type_Alxf = new alxf(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Alxf.a();
    this.jdField_a_of_type_Alxf.a(new bkmj(this));
    this.b = new alxf(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bkmk(this));
    this.c = new alxf(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bkml(this));
    this.d = new alxf(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bkmm(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alxf != null) {
      this.jdField_a_of_type_Alxf.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bkmn parambkmn)
  {
    if ((parambkmn == null) || (parambkmn.jdField_a_of_type_Bkmo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bkmo localbkmo = parambkmn.jdField_a_of_type_Bkmo;
    if ((localbkmo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbkmo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambkmn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbkmo.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label304:
    for (;;)
    {
      parambkmn.jdField_a_of_type_AndroidWidgetTextView.setText(localbkmo.jdField_c_of_type_JavaLangString);
      parambkmn.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambkmn);
      parambkmn.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambkmn);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbkmo.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambkmn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbkmo.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambkmn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbkmo.jdField_a_of_type_Int == 0) || (localbkmo.jdField_a_of_type_Int == 1000) || (localbkmo.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Alxf.a(localbkmo.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label304;
          }
          parambkmn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbkmo.jdField_a_of_type_Int == 1)
          {
            if (localbkmo.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbkmo.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbkmo.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbkmo.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbkmo.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bkmo parambkmo)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambkmo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambkmo);
  }
  
  public void a(bkmr parambkmr)
  {
    this.jdField_a_of_type_Bkmr = parambkmr;
  }
  
  public void a(List<bkmo> paramList)
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
      Object localObject = (bkmo)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bkmo)localObject).e)) && (TextUtils.isEmpty(((bkmo)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bkmr != null)) {
        avtd.c(this.jdField_a_of_type_Bkmr.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bkmo)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bkmo)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bkmo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bkmo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    paramViewGroup = (bkmo)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562426, null);
      localbkmn = new bkmn(this);
      localbkmn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367679));
      localbkmn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370647));
      localbkmn.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131371109));
      localbkmn.jdField_a_of_type_Bkmo = paramViewGroup;
      a(paramInt, localbkmn);
      paramView.setTag(localbkmn);
      return paramView;
    }
    bkmn localbkmn = (bkmn)paramView.getTag();
    localbkmn.jdField_a_of_type_Bkmo = paramViewGroup;
    a(paramInt, localbkmn);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bkmn))
    {
      paramView = (bkmn)paramView.getTag();
      if (paramView.jdField_a_of_type_Bkmo != null) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    label41:
    bkmo localbkmo;
    label255:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + paramView.jdField_a_of_type_Bkmo.jdField_b_of_type_Int);
        }
        switch (paramView.jdField_a_of_type_Bkmo.jdField_b_of_type_Int)
        {
        default: 
          return;
        case 0: 
          if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
          {
            bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719789), 0).a();
            return;
          }
          if (!TextUtils.isEmpty(paramView.jdField_a_of_type_Bkmo.g))
          {
            localbkmo = a(paramView.jdField_a_of_type_Bkmo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bkmo.jdField_a_of_type_Int, 1);
            Object localObject;
            int i;
            if (localbkmo != null)
            {
              paramView.jdField_a_of_type_Bkmo = localbkmo;
              a(paramView);
              if (localbkmo.jdField_a_of_type_Boolean) {
                bjmu.a(localbkmo.e, localbkmo.f, localbkmo, bkmp.a().jdField_a_of_type_JavaLangString);
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bkmr != null) {
                avtd.c(this.jdField_a_of_type_Bkmr.a, localbkmo);
              }
              localObject = bizt.a();
              paramView = paramView.jdField_a_of_type_Bkmo.g;
              if (localbkmo != null) {
                break label317;
              }
              i = -1;
              ((bizt)localObject).a(paramView, i);
              localObject = new StringBuilder().append("【OnClick】messageType:");
              if (localbkmo != null) {
                break label325;
              }
            }
            for (paramView = "-1";; paramView = Integer.valueOf(localbkmo.jdField_a_of_type_Int))
            {
              bjah.b("SendPanelAdapter", paramView);
              return;
              bjmu.a(localbkmo.e, localbkmo, bkmp.a().jdField_a_of_type_JavaLangString);
              break;
              i = localbkmo.jdField_a_of_type_Int;
              break label255;
            }
          }
          this.jdField_a_of_type_Bkmr.a.a(49, paramView.jdField_a_of_type_Bkmo);
          this.jdField_a_of_type_Bkmr.a.d();
          return;
        case 1: 
          localbkmo = a(paramView.jdField_a_of_type_Bkmo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bkmo.jdField_a_of_type_Int, 0);
          if (localbkmo != null)
          {
            paramView.jdField_a_of_type_Bkmo = localbkmo;
            a(paramView);
            bjmu.a(localbkmo);
          }
          break;
        }
      } while (this.jdField_a_of_type_Bkmr == null);
      avtd.b(this.jdField_a_of_type_Bkmr.a, localbkmo);
      return;
      if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719789), 0).a();
        return;
      }
      localbkmo = a(paramView.jdField_a_of_type_Bkmo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bkmo.jdField_a_of_type_Int, 1);
      if (localbkmo != null)
      {
        paramView.jdField_a_of_type_Bkmo = localbkmo;
        a(paramView);
        bjmu.b(localbkmo);
      }
    } while (this.jdField_a_of_type_Bkmr == null);
    label317:
    label325:
    avtd.a(this.jdField_a_of_type_Bkmr.a, localbkmo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmi
 * JD-Core Version:    0.7.0.1
 */