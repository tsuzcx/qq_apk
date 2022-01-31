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

public class anja
  extends BaseAdapter
{
  public static LruCache<String, URL> a;
  int jdField_a_of_type_Int;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public QQAppInterface a;
  List<anjb> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public anja(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837708);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837709);
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131099964);
    this.jdField_b_of_type_Int = paramInt;
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
    Object localObject = (anbh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    int j;
    if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (localObject != null) && (((anbh)localObject).c()))
    {
      j = 2;
      return j;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label102;
      }
      anjb localanjb = (anjb)((Iterator)localObject).next();
      if (localanjb != null)
      {
        j = i;
        if (localanjb.jdField_a_of_type_Int == paramInt) {
          break;
        }
      }
      i += 1;
    }
    label102:
    return 0;
  }
  
  public Drawable a(anjb paramanjb)
  {
    URL localURL = a(paramanjb.jdField_a_of_type_JavaLangString, paramanjb.jdField_a_of_type_Boolean);
    Object localObject = null;
    if (localURL != null)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (10 != paramanjb.jdField_a_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = Boolean.valueOf(bool);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonTabAdapter", 2, "getTabDrawable, completed = " + paramanjb.jdField_a_of_type_Boolean + ", epId = " + paramanjb.jdField_a_of_type_JavaLangString);
      }
      paramanjb = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      localObject = paramanjb;
      if (paramanjb.getStatus() == 2)
      {
        paramanjb.restartDownload();
        localObject = paramanjb;
      }
      return localObject;
    }
  }
  
  public void a(List<anjb> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
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
    anjc localanjc;
    if (paramView == null)
    {
      localanjc = new anjc(this);
      paramView = HorizontalListViewEx.a();
      if (paramView != null) {
        break label588;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493473, paramViewGroup, false);
    }
    label174:
    label588:
    for (;;)
    {
      localanjc.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131310978));
      localanjc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131309293));
      localanjc.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131310975);
      localanjc.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramView.setTag(localanjc);
      Object localObject;
      for (paramViewGroup = paramView;; paramViewGroup = paramView)
      {
        localObject = (anjb)getItem(paramInt);
        if (localObject != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + paramInt);
        localObject = null;
        return localObject;
        localanjc = (anjc)paramView.getTag();
      }
      paramView = localanjc.jdField_a_of_type_AndroidViewView;
      if (paramInt != getCount() - 1)
      {
        paramInt = 0;
        paramView.setVisibility(paramInt);
        localanjc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        switch (((anjb)localObject).jdField_a_of_type_Int)
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
        localanjc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
        return paramViewGroup;
        paramInt = 4;
        break label174;
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846050);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject = (arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          if ((localObject != null) && (((arnz)localObject).a(this.jdField_b_of_type_Int)))
          {
            localanjc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846040);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846039);
            continue;
            if (((anbh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334)).b()) {
              localanjc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837695);
            continue;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837707);
            continue;
            paramView = a((anjb)localObject);
            if (paramView == null)
            {
              paramView = new StateListDrawable();
              Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
              paramView.addState(new int[] { 16842913 }, localDrawable);
              localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              paramView.addState(new int[0], localDrawable);
              ThreadManager.post(new EmoticonTabAdapter.1(this, (anjb)localObject), 5, null, false);
            }
            else {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anja
 * JD-Core Version:    0.7.0.1
 */