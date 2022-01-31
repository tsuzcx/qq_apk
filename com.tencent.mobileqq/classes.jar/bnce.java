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

public class bnce
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ansn jdField_a_of_type_Ansn;
  private bnca jdField_a_of_type_Bnca;
  private bncn jdField_a_of_type_Bncn;
  private List<bnck> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ansn b;
  private ansn c;
  private ansn d;
  
  public bnce(Context paramContext, bnca parambnca)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bnca = parambnca;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a();
    this.jdField_a_of_type_Int = aepi.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    apkp localapkp = new apkp(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localapkp, localapkp);
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
    return localapkp;
  }
  
  private bnck a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bnck localbnck = (bnck)localIterator.next();
        if ((!TextUtils.isEmpty(localbnck.jdField_a_of_type_JavaLangString)) && (paramString.equals(localbnck.jdField_a_of_type_JavaLangString)) && (paramInt1 == localbnck.jdField_a_of_type_Int))
        {
          localbnck.jdField_b_of_type_Int = paramInt2;
          if (localbnck.jdField_b_of_type_Int == 1) {
            localbnck.jdField_b_of_type_Boolean = true;
          }
          return localbnck;
        }
      }
    }
    return null;
  }
  
  private void a(bncj parambncj)
  {
    if ((parambncj == null) || (parambncj.jdField_a_of_type_Bnck == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parambncj.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(parambncj.jdField_a_of_type_Bnck.jdField_b_of_type_Int);
    } while (parambncj.jdField_a_of_type_Bnck.jdField_b_of_type_Int != 1);
    parambncj.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(parambncj.jdField_a_of_type_Bnck.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (bdhb.b(paramString))
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
    this.jdField_a_of_type_Ansn = new ansn(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Ansn.a();
    this.jdField_a_of_type_Ansn.a(new bncf(this));
    this.b = new ansn(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new bncg(this));
    this.c = new ansn(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new bnch(this));
    this.d = new ansn(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new bnci(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ansn != null) {
      this.jdField_a_of_type_Ansn.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, bncj parambncj)
  {
    if ((parambncj == null) || (parambncj.jdField_a_of_type_Bnck == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    bnck localbnck = parambncj.jdField_a_of_type_Bnck;
    if ((localbnck.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localbnck.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      parambncj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localbnck.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label304:
    for (;;)
    {
      parambncj.jdField_a_of_type_AndroidWidgetTextView.setText(localbnck.jdField_c_of_type_JavaLangString);
      parambncj.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(parambncj);
      parambncj.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(parambncj);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localbnck.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parambncj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localbnck.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, parambncj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localbnck.jdField_a_of_type_Int == 0) || (localbnck.jdField_a_of_type_Int == 1000) || (localbnck.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_Ansn.a(localbnck.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label304;
          }
          parambncj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localbnck.jdField_a_of_type_Int == 1)
          {
            if (localbnck.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localbnck.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localbnck.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localbnck.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localbnck.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, bnck parambnck)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (parambnck == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, parambnck);
  }
  
  public void a(bncn parambncn)
  {
    this.jdField_a_of_type_Bncn = parambncn;
  }
  
  public void a(List<bnck> paramList)
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
      Object localObject = (bnck)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((bnck)localObject).e)) && (TextUtils.isEmpty(((bnck)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Bncn != null)) {
        axpl.c(this.jdField_a_of_type_Bncn.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bnck)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((bnck)this.jdField_a_of_type_JavaUtilList.get(0)).e);
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
      return (bnck)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((bnck)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
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
    paramViewGroup = (bnck)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562648, null);
      localbncj = new bncj(this);
      localbncj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367819));
      localbncj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370977));
      localbncj.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131371441));
      localbncj.jdField_a_of_type_Bnck = paramViewGroup;
      a(paramInt, localbncj);
      paramView.setTag(localbncj);
      return paramView;
    }
    bncj localbncj = (bncj)paramView.getTag();
    localbncj.jdField_a_of_type_Bnck = paramViewGroup;
    a(paramInt, localbncj);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bncj))
    {
      paramView = (bncj)paramView.getTag();
      if (paramView.jdField_a_of_type_Bnck != null) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    label41:
    bnck localbnck;
    label261:
    label329:
    label337:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + paramView.jdField_a_of_type_Bnck.jdField_b_of_type_Int);
        }
        switch (paramView.jdField_a_of_type_Bnck.jdField_b_of_type_Int)
        {
        default: 
          return;
        case 0: 
          if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131720327), 0).a();
            return;
          }
          if (!TextUtils.isEmpty(paramView.jdField_a_of_type_Bnck.g))
          {
            localbnck = a(paramView.jdField_a_of_type_Bnck.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bnck.jdField_a_of_type_Int, 1);
            Object localObject;
            int i;
            if (localbnck != null)
            {
              paramView.jdField_a_of_type_Bnck = localbnck;
              a(paramView);
              if (localbnck.jdField_a_of_type_Boolean) {
                bmcp.a(localbnck.e, localbnck.f, localbnck, bncl.a().jdField_a_of_type_JavaLangString, bncl.a().a());
              }
            }
            else
            {
              if (this.jdField_a_of_type_Bncn != null) {
                axpl.c(this.jdField_a_of_type_Bncn.a, localbnck);
              }
              localObject = bliu.a();
              paramView = paramView.jdField_a_of_type_Bnck.g;
              if (localbnck != null) {
                break label329;
              }
              i = -1;
              ((bliu)localObject).a(paramView, i);
              localObject = new StringBuilder().append("【OnClick】messageType:");
              if (localbnck != null) {
                break label337;
              }
            }
            for (paramView = "-1";; paramView = Integer.valueOf(localbnck.jdField_a_of_type_Int))
            {
              bljn.b("SendPanelAdapter", paramView);
              return;
              bmcp.a(localbnck.e, localbnck, bncl.a().jdField_a_of_type_JavaLangString, bncl.a().a());
              break;
              i = localbnck.jdField_a_of_type_Int;
              break label261;
            }
          }
          this.jdField_a_of_type_Bncn.a.a(49, paramView.jdField_a_of_type_Bnck);
          this.jdField_a_of_type_Bncn.a.d();
          return;
        case 1: 
          localbnck = a(paramView.jdField_a_of_type_Bnck.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bnck.jdField_a_of_type_Int, 0);
          if (localbnck != null)
          {
            paramView.jdField_a_of_type_Bnck = localbnck;
            a(paramView);
            bmcp.a(localbnck);
          }
          break;
        }
      } while (this.jdField_a_of_type_Bncn == null);
      axpl.b(this.jdField_a_of_type_Bncn.a, localbnck);
      return;
      if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131720327), 0).a();
        return;
      }
      localbnck = a(paramView.jdField_a_of_type_Bnck.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Bnck.jdField_a_of_type_Int, 1);
      if (localbnck != null)
      {
        paramView.jdField_a_of_type_Bnck = localbnck;
        a(paramView);
        bmcp.b(localbnck);
      }
    } while (this.jdField_a_of_type_Bncn == null);
    axpl.a(this.jdField_a_of_type_Bncn.a, localbnck);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnce
 * JD-Core Version:    0.7.0.1
 */