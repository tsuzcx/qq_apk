package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.graphics.Bitmap;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
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
  private List<Face2FaceFriendInfo> a;
  private BaseActivity b;
  private QQAppInterface c;
  private IFaceDecoder d;
  private RecyclerView e;
  private boolean f;
  private Set<String> g;
  private DecodeTaskCompletionListener h = new Face2FaceAddContactAdapter.1(this);
  
  Face2FaceAddContactAdapter(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.b = paramBaseActivity;
    this.c = paramQQAppInterface;
    this.e = paramRecyclerView;
    this.d = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.d.setDecodeTaskCompletionListener(this.h);
    this.f = SimpleUIUtil.e();
    this.g = new HashSet();
    this.a = new ArrayList();
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, Face2FaceFriendInfo paramFace2FaceFriendInfo)
  {
    if (paramBoolean)
    {
      paramViewHolder = (Face2FaceAddContactAdapter.LoadingViewHolder)paramViewHolder;
      paramViewHolder.b.setImageResource(2130840306);
      paramViewHolder.c.setText(null);
      paramViewHolder.a = "";
      paramViewHolder.d.setVisibility(0);
      paramViewHolder.d.setAnimation("face2face/normal_loading.json");
      paramViewHolder.d.loop(true);
      paramViewHolder.d.playAnimation();
      return;
    }
    Face2FaceAddContactAdapter.AvatarViewHolder localAvatarViewHolder = (Face2FaceAddContactAdapter.AvatarViewHolder)paramViewHolder;
    if (paramFace2FaceFriendInfo != null)
    {
      if (TextUtils.isEmpty(paramFace2FaceFriendInfo.a)) {
        return;
      }
      localAvatarViewHolder.b.setImageBitmap(a(paramFace2FaceFriendInfo.a));
      localAvatarViewHolder.b.setOnTouchListener(UITools.a);
      localAvatarViewHolder.b.setOnClickListener(localAvatarViewHolder);
      if (TextUtils.isEmpty(paramFace2FaceFriendInfo.b)) {
        paramViewHolder = b(paramFace2FaceFriendInfo.a);
      } else {
        paramViewHolder = paramFace2FaceFriendInfo.b;
      }
      localAvatarViewHolder.c.setText(b(paramViewHolder));
      localAvatarViewHolder.a = paramFace2FaceFriendInfo.a;
      if (paramFace2FaceFriendInfo.a())
      {
        if (!this.g.contains(paramFace2FaceFriendInfo.a))
        {
          localAvatarViewHolder.b.setAlpha(0.5F);
          localAvatarViewHolder.d.setVisibility(0);
          localAvatarViewHolder.d.setAnimation("face2face/normal_avatar.json");
          localAvatarViewHolder.d.playAnimation();
          localAvatarViewHolder.d.addAnimatorListener(localAvatarViewHolder);
        }
      }
      else if ((localAvatarViewHolder.b.getAlpha() < 1.0D) || (localAvatarViewHolder.d.getVisibility() != 4))
      {
        localAvatarViewHolder.d.setVisibility(4);
        localAvatarViewHolder.b.setAlpha(1.0F);
      }
      ViewCompat.setImportantForAccessibility(localAvatarViewHolder.c, 1);
      ViewCompat.setImportantForAccessibility(localAvatarViewHolder.b, 1);
      ViewCompat.setImportantForAccessibility(localAvatarViewHolder.itemView, 1);
    }
  }
  
  private String b(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager == null) {
      return paramString;
    }
    String str = paramString;
    if (localFriendsManager.n(paramString)) {
      str = ContactUtils.a(this.c, paramString);
    }
    return str;
  }
  
  private void c(String paramString)
  {
    paramString = new AllInOne(paramString, 113);
    paramString.profileEntryType = 126;
    ProfileUtils.openProfileCard(this.b, paramString);
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      Bitmap localBitmap = ((IFaceDecoder)localObject).getBitmapFromCache(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.d.requestDecodeFace(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    else
    {
      localObject = null;
    }
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = ImageUtil.k();
    }
    return paramString;
  }
  
  public void a()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((Set)localObject).clear();
    }
    localObject = this.a;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  void b()
  {
    this.c = null;
    this.b = null;
    this.e = null;
    a();
    IFaceDecoder localIFaceDecoder = this.d;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.setDecodeTaskCompletionListener(null);
      this.h = null;
      this.d.destory();
    }
  }
  
  protected List<Face2FaceFriendInfo> c()
  {
    return this.a;
  }
  
  public int getItemCount()
  {
    return this.a.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof Face2FaceAddContactAdapter.LoadingViewHolder)) {
      a(true, paramViewHolder, null);
    } else {
      a(false, paramViewHolder, (Face2FaceFriendInfo)this.a.get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.b).inflate(2131627456, paramViewGroup, false);
    if (paramInt == 1) {
      return new Face2FaceAddContactAdapter.LoadingViewHolder(this, paramViewGroup);
    }
    return new Face2FaceAddContactAdapter.AvatarViewHolder(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactAdapter
 * JD-Core Version:    0.7.0.1
 */