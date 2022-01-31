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

public class aprl
  extends BaseAdapter
{
  public static LruCache<String, URL> a;
  private int jdField_a_of_type_Int;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public QQAppInterface a;
  List<aprm> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  Drawable b;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public aprl(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837914);
    this.b = paramContext.getResources().getDrawable(2130837915);
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
    Object localObject = (apjf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    int j;
    if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (11 == paramInt) && (localObject != null) && (((apjf)localObject).c()))
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
      aprm localaprm = (aprm)((Iterator)localObject).next();
      if (localaprm != null)
      {
        j = i;
        if (localaprm.jdField_a_of_type_Int == paramInt) {
          break;
        }
      }
      i += 1;
    }
    label108:
    return 0;
  }
  
  public Drawable a(aprm paramaprm)
  {
    URL localURL = a(paramaprm.jdField_a_of_type_JavaLangString, paramaprm.jdField_a_of_type_Boolean);
    Object localObject = null;
    if (localURL != null)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (10 != paramaprm.jdField_a_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = Boolean.valueOf(bool);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonTabAdapter", 2, "getTabDrawable, completed = " + paramaprm.jdField_a_of_type_Boolean + ", epId = " + paramaprm.jdField_a_of_type_JavaLangString);
      }
      paramaprm = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      localObject = paramaprm;
      if (paramaprm.getStatus() == 2)
      {
        paramaprm.restartDownload();
        localObject = paramaprm;
      }
      return localObject;
    }
  }
  
  public void a(List<aprm> paramList)
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
    aprn localaprn;
    if (paramView == null)
    {
      localaprn = new aprn(this);
      paramView = HorizontalListViewEx.a();
      if (paramView != null) {
        break label612;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559076, paramViewGroup, false);
    }
    label187:
    label612:
    for (;;)
    {
      localaprn.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377302));
      localaprn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375521));
      localaprn.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365645);
      paramView.setTag(localaprn);
      Object localObject;
      for (paramViewGroup = paramView;; paramViewGroup = paramView)
      {
        localObject = (aprm)getItem(paramInt);
        if (localObject != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + paramInt);
        localObject = null;
        return localObject;
        localaprn = (aprn)paramView.getTag();
      }
      localaprn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.setBackgroundDrawable(null);
        localaprn.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839460));
        switch (((aprm)localObject).jdField_a_of_type_Int)
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
        localaprn.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
        return paramViewGroup;
        localaprn.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        paramViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839455));
        break label187;
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846616);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject = (aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          if ((localObject != null) && (((aube)localObject).a(this.jdField_a_of_type_Int)))
          {
            localaprn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846606);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846605);
            continue;
            if (((apjf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334)).b()) {
              localaprn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837820);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837913);
            continue;
            paramView = a((aprm)localObject);
            if (paramView == null)
            {
              paramView = new StateListDrawable();
              Drawable localDrawable = this.b;
              paramView.addState(new int[] { 16842913 }, localDrawable);
              localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              paramView.addState(new int[0], localDrawable);
              ThreadManager.post(new EmoticonTabAdapter.1(this, (aprm)localObject), 5, null, false);
            }
            else {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprl
 * JD-Core Version:    0.7.0.1
 */