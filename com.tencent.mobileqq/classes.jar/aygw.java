import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class aygw
{
  protected int a;
  protected ayfw a;
  aygy a;
  protected final List<PlusPanelAppInfo> a;
  private final List<aygj> b = new ArrayList();
  
  public aygw()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ayfw = new ayfw();
    this.jdField_a_of_type_Aygy = new aygx();
    a(new aygm());
  }
  
  private Drawable a(QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo, String paramString1, String paramString2, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      if (TextUtils.isEmpty(paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PlusPanelAppLoader", 2, "plusPanel reload simpleNightUrl is null!");
        }
        return a(paramQQAppInterface, paramPlusPanelAppInfo, paramURLDrawableOptions);
      }
      return URLDrawable.getDrawable(paramString2, paramURLDrawableOptions);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelAppLoader", 2, "plusPanel reload simpleDayUrl is null!");
      }
      return a(paramQQAppInterface, paramPlusPanelAppInfo, paramURLDrawableOptions);
    }
    return URLDrawable.getDrawable(paramString1, paramURLDrawableOptions);
  }
  
  private Drawable b(QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return a(paramQQAppInterface, paramPlusPanelAppInfo, paramPlusPanelAppInfo.simpleDayUrl, paramPlusPanelAppInfo.simpleNightUrl, paramURLDrawableOptions);
  }
  
  private String b(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    String str = paramPlusPanelAppInfo.name;
    switch (amvi.a())
    {
    default: 
      return str;
    case 2052: 
      return paramPlusPanelAppInfo.name;
    }
    return paramPlusPanelAppInfo.enName;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected Drawable a(QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (paramPlusPanelAppInfo.defaultDrawableID() > 0)
        {
          i = paramPlusPanelAppInfo.defaultDrawableID();
          localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(i);
          localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(i);
          if (bbyp.b()) {
            return b(paramQQAppInterface, paramPlusPanelAppInfo, localURLDrawableOptions);
          }
          paramQQAppInterface = a(paramQQAppInterface, paramPlusPanelAppInfo, localURLDrawableOptions);
          return paramQQAppInterface;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return localResources.getDrawable(2130843697);
      }
      int i = 2130843697;
    }
  }
  
  protected Drawable a(QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    paramQQAppInterface = paramPlusPanelAppInfo.iconUrl;
    if (TextUtils.isEmpty(paramQQAppInterface))
    {
      int i = paramPlusPanelAppInfo.defaultDrawableID();
      if (i > 0) {
        return BaseApplicationImpl.getContext().getResources().getDrawable(i);
      }
    }
    else
    {
      return URLDrawable.getDrawable(paramQQAppInterface, paramURLDrawableOptions);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130843697);
  }
  
  public abstract ayfo a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt);
  
  public PlusPanelAppInfo a(int paramInt)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      if (((PlusPanelAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).getAppID() == paramInt) {
        return (PlusPanelAppInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  protected String a(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    String str2 = b(paramPlusPanelAppInfo);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramPlusPanelAppInfo.getTitle();
    }
    return str1;
  }
  
  public List<PlusPanelAppInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a(int paramInt)
  {
    if (bbyp.b())
    {
      a(paramInt, 1104864054);
      a(paramInt, 1200000003);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    PlusPanelAppInfo localPlusPanelAppInfo = this.jdField_a_of_type_Ayfw.a(paramInt1, paramInt2);
    if (localPlusPanelAppInfo != null) {
      this.jdField_a_of_type_JavaUtilList.add(localPlusPanelAppInfo);
    }
  }
  
  public void a(aygj paramaygj)
  {
    if (paramaygj != null) {
      this.b.add(paramaygj);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    com.tencent.mobileqq.shortvideo.ShortVideoUtils.sSupportShortVideo = this.jdField_a_of_type_Aygy.a();
  }
  
  protected void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((aygj)localIterator.next()).a(this, paramQQAppInterface, paramInt, paramString);
    }
  }
  
  public void a(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    if ((paramPlusPanelAppInfo != null) && (paramPlusPanelAppInfo.getAppID() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramPlusPanelAppInfo);
    }
  }
  
  public void b(int paramInt)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((PlusPanelAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).getAppID() == paramInt) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygw
 * JD-Core Version:    0.7.0.1
 */