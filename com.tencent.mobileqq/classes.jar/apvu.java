import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class apvu
  extends BaseAdapter
{
  public static LruCache<String, URL> a;
  private int jdField_a_of_type_Int;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public QQAppInterface a;
  List<apvv> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  Drawable b;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public apvu(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837915);
    this.b = paramContext.getResources().getDrawable(2130837916);
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
  
  public int a(int paramInt)
  {
    Object localObject = (apno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    int j;
    if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (11 == paramInt) && (localObject != null) && (((apno)localObject).c()))
    {
      j = 2;
      return j;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label108;
      }
      apvv localapvv = (apvv)((Iterator)localObject).next();
      if (localapvv != null)
      {
        j = i;
        if (localapvv.jdField_a_of_type_Int == paramInt) {
          break;
        }
      }
      i += 1;
    }
    label108:
    return 0;
  }
  
  public Drawable a(apvv paramapvv)
  {
    URL localURL = a(paramapvv.jdField_a_of_type_JavaLangString, paramapvv.jdField_a_of_type_Boolean);
    Object localObject = null;
    if (localURL != null)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (10 != paramapvv.jdField_a_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = Boolean.valueOf(bool);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonTabAdapter", 2, "getTabDrawable, completed = " + paramapvv.jdField_a_of_type_Boolean + ", epId = " + paramapvv.jdField_a_of_type_JavaLangString);
      }
      paramapvv = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      localObject = paramapvv;
      if (paramapvv.getStatus() == 2)
      {
        paramapvv.restartDownload();
        localObject = paramapvv;
      }
      return localObject;
    }
  }
  
  public void a(List<apvv> paramList)
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
    apvw localapvw;
    if (paramView == null)
    {
      localapvw = new apvw(this);
      paramView = HorizontalListViewEx.a();
      if (paramView != null) {
        break label612;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559075, paramViewGroup, false);
    }
    label187:
    label612:
    for (;;)
    {
      localapvw.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377356));
      localapvw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375572));
      localapvw.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365647);
      paramView.setTag(localapvw);
      Object localObject;
      for (paramViewGroup = paramView;; paramViewGroup = paramView)
      {
        localObject = (apvv)getItem(paramInt);
        if (localObject != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + paramInt);
        localObject = null;
        return localObject;
        localapvw = (apvw)paramView.getTag();
      }
      localapvw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.setBackgroundDrawable(null);
        localapvw.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839461));
        switch (((apvv)localObject).jdField_a_of_type_Int)
        {
        case 5: 
        default: 
          paramView = null;
        }
      }
      for (;;)
      {
        localObject = paramViewGroup;
        if (paramView == null) {
          break;
        }
        localapvw.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
        return paramViewGroup;
        localapvw.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        paramViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839456));
        break label187;
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846689);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject = (aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          if ((localObject != null) && (((aufn)localObject).a(this.jdField_a_of_type_Int)))
          {
            localapvw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846679);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846678);
            continue;
            if (((apno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334)).b()) {
              localapvw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837833);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837914);
            continue;
            paramView = a((apvv)localObject);
            if (paramView == null)
            {
              paramView = new StateListDrawable();
              Drawable localDrawable = this.b;
              paramView.addState(new int[] { 16842913 }, localDrawable);
              localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              paramView.addState(new int[0], localDrawable);
              ThreadManager.post(new EmoticonTabAdapter.1(this, (apvv)localObject), 5, null, false);
            }
            else {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvu
 * JD-Core Version:    0.7.0.1
 */