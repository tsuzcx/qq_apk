import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class asop
  extends BaseAdapter
{
  public static LruCache<String, URL> a;
  private int jdField_a_of_type_Int;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public QQAppInterface a;
  List<asoq> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  Drawable b;
  Drawable c;
  Drawable d;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public asop(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130838018);
    this.b = paramContext.getResources().getDrawable(2130838019);
    this.c = bhtq.a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166503), bhtq.a(18.0F));
    this.d = new ColorDrawable(0);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static URL a(String paramString, boolean paramBoolean)
  {
    Object localObject2;
    if (paramString == null)
    {
      localObject2 = null;
      return localObject2;
    }
    label98:
    for (;;)
    {
      try
      {
        Object localObject1 = (URL)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString + "_" + paramBoolean);
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 2, "generateTabUrl error = " + localMalformedURLException1.getMessage());
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          localObject2 = new URL("protocol_vas_extension_image", "EMOTICON_TAB", paramString + "_" + paramBoolean);
          localObject1 = localObject2;
          jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
          return localObject1;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          break label98;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localObject1 = null;
      }
    }
  }
  
  public static void a(String paramString) {}
  
  public Drawable a(asoq paramasoq)
  {
    URL localURL = a(paramasoq.jdField_a_of_type_JavaLangString, paramasoq.jdField_a_of_type_Boolean);
    Object localObject = null;
    if (localURL != null)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (10 != paramasoq.jdField_a_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = Boolean.valueOf(bool);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonTabAdapter", 2, "getTabDrawable, completed = " + paramasoq.jdField_a_of_type_Boolean + ", epId = " + paramasoq.jdField_a_of_type_JavaLangString);
      }
      paramasoq = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      localObject = paramasoq;
      if (paramasoq.getStatus() == 2)
      {
        paramasoq.restartDownload();
        localObject = paramasoq;
      }
      return localObject;
    }
  }
  
  public void a(List<asoq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      QLog.e("EmoticonTabAdapter", 1, "getItem error");
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    asor localasor;
    if (paramView == null)
    {
      localasor = new asor(this);
      paramView = HorizontalListViewEx.a();
      if (paramView != null) {
        break label725;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559144, paramViewGroup, false);
    }
    label725:
    for (;;)
    {
      localasor.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378339));
      localasor.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376428));
      localasor.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365925);
      paramView.setTag(localasor);
      Object localObject;
      for (View localView = paramView;; localView = paramView)
      {
        localObject = (asoq)getItem(paramInt);
        if (localObject != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + paramInt);
        paramView = null;
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localasor = (asor)paramView.getTag();
      }
      localasor.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable;
      if (this.jdField_a_of_type_Boolean)
      {
        localView.setBackgroundDrawable(null);
        paramView = new StateListDrawable();
        localDrawable = this.c;
        paramView.addState(new int[] { 16842913 }, localDrawable);
        localDrawable = this.d;
        paramView.addState(new int[0], localDrawable);
        localasor.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramView);
        label235:
        switch (((asoq)localObject).jdField_a_of_type_Int)
        {
        case 5: 
        default: 
          paramView = null;
        }
      }
      for (;;)
      {
        if (paramView != null) {
          localasor.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
        }
        paramView = localView;
        break;
        localasor.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839639));
        break label235;
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847154);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject = (axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          if ((localObject != null) && (((axfj)localObject).a(this.jdField_a_of_type_Int)))
          {
            localasor.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847138);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847137);
            continue;
            if (((asfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334)).b()) {
              localasor.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837999);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838017);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838002);
            continue;
            paramView = a((asoq)localObject);
            if (paramView == null)
            {
              paramView = new StateListDrawable();
              localDrawable = this.b;
              paramView.addState(new int[] { 16842913 }, localDrawable);
              localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              paramView.addState(new int[0], localDrawable);
              ThreadManager.post(new EmoticonTabAdapter.1(this, (asoq)localObject), 5, null, false);
              continue;
              paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847146);
              continue;
              paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847147);
            }
            else {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asop
 * JD-Core Version:    0.7.0.1
 */