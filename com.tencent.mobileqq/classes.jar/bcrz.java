import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class bcrz
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting = null;
  String jdField_a_of_type_JavaLangString;
  WeakReference<TextView> jdField_a_of_type_JavaLangRefWeakReference = null;
  protected List<String> a;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString = null;
  protected List<String> b;
  boolean jdField_b_of_type_Boolean = true;
  boolean c = false;
  
  public bcrz(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131297345));
  }
  
  private URL a(URL paramURL)
  {
    URL localURL = paramURL;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localURL = paramURL;
      if ("2000".equals(this.jdField_b_of_type_JavaLangString))
      {
        localURL = paramURL;
        if (paramURL.getProtocol().startsWith("http")) {
          localURL = swu.a(paramURL.toString(), 2);
        }
      }
    }
    return localURL;
  }
  
  private boolean a(int paramInt)
  {
    return (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > paramInt) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilList.get(paramInt))) && (baqn.a((String)this.jdField_b_of_type_JavaUtilList.get(paramInt)) != null);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, bcsb parambcsb)
  {
    if ((parambcsb == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    URLImageView localURLImageView;
    ImageProgressCircle localImageProgressCircle;
    label67:
    Object localObject;
    label83:
    label217:
    label219:
    do
    {
      return;
      localURLImageView = parambcsb.jdField_a_of_type_ComTencentImageURLImageView;
      localImageProgressCircle = parambcsb.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
      parambcsb = a(paramInt);
      if ((this.c) || (a(paramInt)))
      {
        parambcsb = (String)this.jdField_b_of_type_JavaUtilList.get(paramInt);
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load origin");
        if (TextUtils.isEmpty(parambcsb)) {
          break label217;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label219;
        }
        localObject = parambcsb;
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarBigPhotoAdapter", 2, "loadThumbImage() path = " + (String)localObject);
        }
        String str = Uri.parse((String)localObject).getScheme();
        if ((!TextUtils.isEmpty(str)) && ((str.equals("http")) || (str.equals("https")))) {
          break label294;
        }
      }
      for (;;)
      {
        try
        {
          localObject = new File((String)localObject).toURL();
          localObject = a((URL)localObject);
          if (((this.jdField_a_of_type_ComTencentMobileqqDataSetting != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType != 0)) || (parambcsb == null) || (!parambcsb.equals(ainn.jdField_a_of_type_JavaLangString))) {
            break label324;
          }
          localURLImageView.setImageResource(2130842141);
          return;
        }
        catch (MalformedURLException parambcsb) {}
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load current");
        break label67;
        break;
        if (bckq.b(parambcsb))
        {
          if ((parambcsb != null) && (parambcsb.equals(ainn.jdField_a_of_type_JavaLangString)))
          {
            localObject = bckq.a(parambcsb, this.jdField_a_of_type_JavaLangString, 0);
            localObject = bckq.b((String)localObject);
            break label83;
          }
          localObject = bckq.a(parambcsb, this.jdField_a_of_type_JavaLangString, 1);
          continue;
        }
        localObject = parambcsb;
        break label83;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopAvatarBigPhotoAdapter", 2, parambcsb.toString());
        return;
        try
        {
          localObject = new URL((String)localObject);
        }
        catch (MalformedURLException parambcsb) {}
      }
    } while (!QLog.isColorLevel());
    label294:
    QLog.i("TroopAvatarBigPhotoAdapter", 2, parambcsb.toString());
    return;
    label324:
    parambcsb = URLDrawable.URLDrawableOptions.obtain();
    parambcsb.mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    parambcsb.mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    parambcsb.mLoadingDrawable = bayu.a;
    if (this.jdField_b_of_type_Boolean) {
      parambcsb.mPlayGifImage = true;
    }
    localURLImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject, parambcsb));
    a(localImageProgressCircle);
    localURLImageView.setURLDrawableDownListener(new bcsa(this, localImageProgressCircle, localURLImageView));
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTextView);
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, Setting paramSetting)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(List<String> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558853, null);
      paramView = new bcsb(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367921));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368021));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      a(paramInt, paramViewGroup);
      return localView;
      paramViewGroup = (bcsb)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrz
 * JD-Core Version:    0.7.0.1
 */