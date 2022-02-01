package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DiscussionListAdapter2
  extends BaseAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnClickListener a;
  protected DiscussionListAdapter2.DiscussionListListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<DiscussionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new DiscussionListAdapter2.2(this);
  private List<Entity> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  
  public DiscussionListAdapter2(Context paramContext, DiscussionListAdapter2.DiscussionListListener paramDiscussionListListener, ListView paramListView, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new DiscussionListAdapter2.3(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2$DiscussionListListener = paramDiscussionListListener;
    paramListView.setOnScrollListener(this);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      Bitmap localBitmap = paramBitmap;
      if (localObject != null)
      {
        localBitmap = paramBitmap;
        if ((localObject instanceof DiscussionListAdapter2.ViewTag))
        {
          localObject = (DiscussionListAdapter2.ViewTag)localObject;
          if ((paramString == null) && (!TextUtils.isEmpty(((DiscussionListAdapter2.ViewTag)localObject).jdField_a_of_type_JavaLangString)))
          {
            localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(101, ((DiscussionListAdapter2.ViewTag)localObject).jdField_a_of_type_JavaLangString);
            if (localBitmap != null) {
              ((DiscussionListAdapter2.ViewTag)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
            } else {
              this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(((DiscussionListAdapter2.ViewTag)localObject).jdField_a_of_type_JavaLangString, 101, true);
            }
          }
          else
          {
            localBitmap = paramBitmap;
            if (TextUtils.equals(paramString, ((DiscussionListAdapter2.ViewTag)localObject).jdField_a_of_type_JavaLangString))
            {
              ((DiscussionListAdapter2.ViewTag)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
              return;
            }
          }
        }
      }
      i += 1;
      paramBitmap = localBitmap;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
    Object localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720097);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691016);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l1 = 0L;
      String str2 = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
      String str3 = ChnToSpell.a(str2, 1);
      if ((str2.matches((String)localObject2)) || (str2.contains(str1))) {
        l1 = 65536L;
      }
      if ((str3 != null) && (str3.length() != 0))
      {
        if (StringUtil.b(str3.charAt(0))) {}
        for (long l2 = str3.charAt(0);; l2 = 65534L)
        {
          l1 |= l2;
          break label209;
          if (!Character.isDigit(str3.charAt(0))) {
            break;
          }
        }
      }
      l1 |= 0xFFFF;
      label209:
      ((HashMap)localObject1).put(localDiscussionInfo.uin, Long.valueOf(l1));
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new DiscussionListAdapter2.1(this, (HashMap)localObject1));
    this.jdField_b_of_type_JavaUtilList.clear();
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      if (((DiscussionInfo)localObject2).hasCollect) {
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = this.jdField_b_of_type_JavaUtilList.size();
      if (i > 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public DiscussionInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (DiscussionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof DiscussionInfo)) {
      return Long.parseLong(((DiscussionInfo)localObject).uin);
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof Integer)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    DiscussionListAdapter2.ViewTag localViewTag;
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559068, paramViewGroup, false);
        localViewTag = new DiscussionListAdapter2.ViewTag(null);
        localViewTag.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
        localViewTag.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378461));
        localViewTag.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378463));
        localViewTag.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365724));
        localViewTag.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        localViewTag.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        localViewTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.setTag(localViewTag);
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((Button)paramView.findViewById(2131365717)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        localViewTag = (DiscussionListAdapter2.ViewTag)paramView.getTag();
      }
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)getItem(paramInt);
      String str = localDiscussionInfo.uin;
      Object localObject = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
      localViewTag.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localViewTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((DiscussionManager)localObject).a(str)) }));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(101, str);
      if (localObject == null) {
        localViewTag.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(ImageUtil.d());
      } else {
        localViewTag.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentWidgetListView.getResources(), (Bitmap)localObject));
      }
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(str, 101, false);
      }
      localViewTag.jdField_a_of_type_JavaLangString = str;
      localViewTag.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = localDiscussionInfo;
      if (this.jdField_a_of_type_Boolean) {
        localViewTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        localViewTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      if (paramView == null)
      {
        localViewTag = new DiscussionListAdapter2.ViewTag(null);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559067, paramViewGroup, false);
        localViewTag.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365740));
        paramView.setTag(localViewTag);
      }
      else
      {
        localViewTag = (DiscussionListAdapter2.ViewTag)paramView.getTag();
      }
      localViewTag.jdField_a_of_type_JavaLangString = "";
      if ((paramInt == 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
        localViewTag.jdField_a_of_type_AndroidWidgetTextView.setText(2131694344);
      } else {
        localViewTag.jdField_a_of_type_AndroidWidgetTextView.setText(2131694337);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void notifyDataSetChanged()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 0)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      a(null, null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.DiscussionListAdapter2
 * JD-Core Version:    0.7.0.1
 */