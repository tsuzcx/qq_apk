import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class amfx
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  List<bhlk> jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  public amfx(amfs paramamfs) {}
  
  public void a(bhll parambhll)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (parambhll.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambhll.d;
    this.jdField_a_of_type_Int = parambhll.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = parambhll.jdField_b_of_type_Int;
    this.jdField_b_of_type_JavaLangString = parambhll.jdField_c_of_type_JavaLangString;
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    if ((parambhll.e != null) && (parambhll.e.equals("actLiTpl"))) {
      this.jdField_b_of_type_Int = 3;
    }
    if ((!parambhll.jdField_a_of_type_Boolean) && (parambhll.jdField_a_of_type_JavaUtilList.size() > 4) && ((parambhll.e == null) || (parambhll.e.equals("")))) {
      this.jdField_a_of_type_JavaUtilList.addAll(parambhll.jdField_a_of_type_JavaUtilList.subList(0, 4));
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.addAll(parambhll.jdField_a_of_type_JavaUtilList);
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
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    label200:
    label219:
    bhlk localbhlk;
    if (paramView == null)
    {
      localObject1 = new amfy(this);
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidContentContext).inflate(2131561904, paramViewGroup, false);
      ((amfy)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject2).findViewById(2131372529));
      ((amfy)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131372528));
      ((amfy)localObject1).b = ((ImageView)((View)localObject2).findViewById(2131372539));
      ((amfy)localObject1).c = ((ImageView)((View)localObject2).findViewById(2131372541));
      ((amfy)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131372537));
      ((amfy)localObject1).d = ((ImageView)((View)localObject2).findViewById(2131372530));
      ((amfy)localObject1).e = ((ImageView)((View)localObject2).findViewById(2131372540));
      paramView = ((amfy)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = this.jdField_a_of_type_Amfs.g;
        paramView.height = this.jdField_a_of_type_Amfs.h;
        ((amfy)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
        ((View)localObject2).setTag(localObject1);
        paramView = (View)localObject2;
        localbhlk = (bhlk)getItem(paramInt);
        if (localbhlk != null)
        {
          ((amfy)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localbhlk);
          ((amfy)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localbhlk.jdField_a_of_type_JavaLangString);
          paramView.setContentDescription(localbhlk.jdField_a_of_type_JavaLangString);
          switch (localbhlk.e)
          {
          default: 
            ((amfy)localObject1).d.setVisibility(8);
            label302:
            switch (localbhlk.f)
            {
            case 7: 
            case 8: 
            default: 
              ((amfy)localObject1).e.setVisibility(8);
              label350:
              localObject2 = localbhlk.jdField_b_of_type_JavaLangString;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject2 = this.jdField_a_of_type_JavaLangString;
              }
              break;
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject4 = (URLDrawable)amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(localObject2);
        if (localObject4 == null) {
          break label1558;
        }
        ((amfy)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject4);
        if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
          ((URLDrawable)localObject4).restartDownload();
        }
      }
      label434:
      ((amfy)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localbhlk);
      if (this.jdField_a_of_type_Int == paramInt)
      {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847411));
        label471:
        if (localbhlk.jdField_a_of_type_Int == 0) {
          break label1783;
        }
        if (localbhlk.jdField_a_of_type_Int != this.jdField_a_of_type_Amfs.jdField_a_of_type_Long) {
          break label1732;
        }
        ((amfy)localObject1).c.setVisibility(0);
        if (this.jdField_a_of_type_Amfs.jdField_a_of_type_Boolean) {
          break label1771;
        }
      }
      for (;;)
      {
        try
        {
          label1558:
          Object localObject5;
          for (;;)
          {
            localObject2 = new URL("protocol_pendant_image", "AIO_STATIC", String.valueOf(localbhlk.jdField_a_of_type_Int));
            if (localObject2 != null)
            {
              localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.jdField_a_of_type_Amfs.k;
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.jdField_a_of_type_Amfs.l;
              ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
              ((amfy)localObject1).b.setImageDrawable((Drawable)localObject2);
              if (((URLDrawable)localObject2).getStatus() == 2) {
                ((URLDrawable)localObject2).restartDownload();
              }
            }
            localObject1 = paramView;
            break;
            if (QLog.isColorLevel()) {
              QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
            }
            paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_Amfs.g, this.jdField_a_of_type_Amfs.h);
            break label200;
            localObject1 = (amfy)paramView.getTag();
            break label219;
            Object localObject6 = new File(bhcs.jdField_c_of_type_JavaLangString + "/new.png");
            if ((((File)localObject6).exists()) && (!this.jdField_b_of_type_JavaLangString.equals("1")))
            {
              ((amfy)localObject1).d.setVisibility(0);
              localObject4 = (URLDrawable)amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_new.png");
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject4;
                if (((URLDrawable)localObject4).getStatus() == 1)
                {
                  amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_new.png", localObject4);
                  localObject2 = localObject4;
                }
              }
              ((amfy)localObject1).d.setImageDrawable((Drawable)localObject2);
              break label302;
            }
            ((amfy)localObject1).d.setVisibility(8);
            break label302;
            localObject6 = new File(bhcs.jdField_c_of_type_JavaLangString + "/hot.png");
            if ((((File)localObject6).exists()) && (!this.jdField_b_of_type_JavaLangString.equals("3")))
            {
              ((amfy)localObject1).d.setVisibility(0);
              localObject4 = (URLDrawable)amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_hot.png");
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject4;
                if (((URLDrawable)localObject4).getStatus() == 1)
                {
                  amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_hot.png", localObject4);
                  localObject2 = localObject4;
                }
              }
              ((amfy)localObject1).d.setImageDrawable((Drawable)localObject2);
              break label302;
            }
            ((amfy)localObject1).d.setVisibility(8);
            break label302;
            localObject6 = new File(bhcs.jdField_c_of_type_JavaLangString + "/activity.png");
            if ((((File)localObject6).exists()) && (this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 5))
            {
              ((amfy)localObject1).e.setVisibility(0);
              localObject4 = (URLDrawable)amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_activity.png");
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject4;
                if (((URLDrawable)localObject4).getStatus() == 1)
                {
                  amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_activity.png", localObject4);
                  localObject2 = localObject4;
                }
              }
              ((amfy)localObject1).e.setImageDrawable((Drawable)localObject2);
              break label350;
            }
            ((amfy)localObject1).e.setVisibility(8);
            break label350;
            localObject6 = new File(bhcs.jdField_c_of_type_JavaLangString + "/limit.png");
            if (((File)localObject6).exists())
            {
              ((amfy)localObject1).e.setVisibility(0);
              localObject4 = (URLDrawable)amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_limit.png");
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject4;
                if (((URLDrawable)localObject4).getStatus() == 1)
                {
                  amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_limit.png", localObject4);
                  localObject2 = localObject4;
                }
              }
              ((amfy)localObject1).e.setImageDrawable((Drawable)localObject2);
              break label350;
            }
            ((amfy)localObject1).e.setVisibility(8);
            break label350;
            localObject6 = new File(bhcs.jdField_c_of_type_JavaLangString + "/rare.png");
            if ((((File)localObject6).exists()) && (this.jdField_b_of_type_Int != 5))
            {
              ((amfy)localObject1).e.setVisibility(0);
              localObject4 = (URLDrawable)amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject4 = URLDrawable.getDrawable((File)localObject6, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject4;
                if (((URLDrawable)localObject4).getStatus() == 1)
                {
                  amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject4);
                  localObject2 = localObject4;
                }
              }
              ((amfy)localObject1).e.setImageDrawable((Drawable)localObject2);
              break label350;
            }
            ((amfy)localObject1).e.setVisibility(8);
            break label350;
            try
            {
              localObject4 = new URL("protocol_pendant_image", "DEFAULT_HEAD", (String)localObject2);
              if (localObject4 == null) {
                break label434;
              }
              localObject6 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = this.jdField_a_of_type_Amfs.k;
              ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = this.jdField_a_of_type_Amfs.l;
              ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject6).mUseMemoryCache = true;
              ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = this.jdField_a_of_type_Amfs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject4 = URLDrawable.getDrawable((URL)localObject4, (URLDrawable.URLDrawableOptions)localObject6);
              ((amfy)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject4);
              if (((URLDrawable)localObject4).getStatus() == 2) {
                ((URLDrawable)localObject4).restartDownload();
              }
            }
            catch (MalformedURLException localMalformedURLException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AvatarPendantAdapter", 2, localMalformedURLException2.getMessage());
                }
                localObject5 = null;
              }
            }
          }
          if (localObject5.getStatus() != 1) {
            break label434;
          }
          amfs.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localObject2, localObject5);
          break label434;
          paramView.setBackgroundDrawable(null);
          break label471;
          label1732:
          ((amfy)localObject1).c.setVisibility(8);
        }
        catch (MalformedURLException localMalformedURLException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantAdapter", 2, localMalformedURLException1.getMessage());
          }
          Object localObject3 = null;
          continue;
        }
        label1771:
        ((amfy)localObject1).b.setImageDrawable(null);
        continue;
        label1783:
        ((amfy)localObject1).b.setImageDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfx
 * JD-Core Version:    0.7.0.1
 */