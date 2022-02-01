package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Face2FaceAddContactAdapter
  extends RecyclerView.Adapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new Face2FaceAddContactAdapter.1(this);
  private List<Face2FaceFriendInfo> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  Face2FaceAddContactAdapter(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    this.jdField_a_of_type_Boolean = SimpleUIUtil.a();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager == null) {}
    while (!localFriendsManager.b(paramString)) {
      return paramString;
    }
    return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  private void a(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.h = 126;
    ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, Face2FaceFriendInfo paramFace2FaceFriendInfo)
  {
    int i;
    if (paramBoolean)
    {
      paramFace2FaceFriendInfo = (Face2FaceAddContactAdapter.LoadingViewHolder)paramViewHolder;
      paramViewHolder = paramFace2FaceFriendInfo.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 2130840221;
        paramViewHolder.setImageResource(i);
        paramFace2FaceFriendInfo.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        paramFace2FaceFriendInfo.jdField_a_of_type_JavaLangString = "";
        paramFace2FaceFriendInfo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramFace2FaceFriendInfo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        paramFace2FaceFriendInfo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        paramFace2FaceFriendInfo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
    label94:
    Face2FaceAddContactAdapter.AvatarViewHolder localAvatarViewHolder;
    do
    {
      return;
      i = 2130840222;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      localAvatarViewHolder = (Face2FaceAddContactAdapter.AvatarViewHolder)paramViewHolder;
    } while ((paramFace2FaceFriendInfo == null) || (TextUtils.isEmpty(paramFace2FaceFriendInfo.jdField_a_of_type_JavaLangString)));
    localAvatarViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramFace2FaceFriendInfo.jdField_a_of_type_JavaLangString));
    localAvatarViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    localAvatarViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localAvatarViewHolder);
    if (TextUtils.isEmpty(paramFace2FaceFriendInfo.b))
    {
      paramViewHolder = a(paramFace2FaceFriendInfo.jdField_a_of_type_JavaLangString);
      localAvatarViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramViewHolder));
      localAvatarViewHolder.jdField_a_of_type_JavaLangString = paramFace2FaceFriendInfo.jdField_a_of_type_JavaLangString;
      if (!paramFace2FaceFriendInfo.a()) {
        break label319;
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramFace2FaceFriendInfo.jdField_a_of_type_JavaLangString))
      {
        localAvatarViewHolder.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        localAvatarViewHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        localAvatarViewHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        localAvatarViewHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        localAvatarViewHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(localAvatarViewHolder);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(localAvatarViewHolder.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localAvatarViewHolder.jdField_a_of_type_AndroidWidgetImageView, 1);
      ViewCompat.setImportantForAccessibility(localAvatarViewHolder.itemView, 1);
      return;
      paramViewHolder = paramFace2FaceFriendInfo.b;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((localAvatarViewHolder.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 1.0D) || (localAvatarViewHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 4))
      {
        localAvatarViewHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
        localAvatarViewHolder.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = ImageUtil.c();
    }
    return paramString;
  }
  
  protected List<Face2FaceFriendInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = null;
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = null;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof Face2FaceAddContactAdapter.LoadingViewHolder)) {
      a(true, paramViewHolder, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      a(false, paramViewHolder, (Face2FaceFriendInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561262, paramViewGroup, false);
    if (paramInt == 1) {
      return new Face2FaceAddContactAdapter.LoadingViewHolder(this, paramViewGroup);
    }
    return new Face2FaceAddContactAdapter.AvatarViewHolder(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactAdapter
 * JD-Core Version:    0.7.0.1
 */