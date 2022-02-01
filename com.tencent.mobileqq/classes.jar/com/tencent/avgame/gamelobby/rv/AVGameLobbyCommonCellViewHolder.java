package com.tencent.avgame.gamelobby.rv;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelobby.view.OverlappingImgLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AVGameLobbyCommonCellViewHolder
  extends BaseViewHolder<AVGameLobbyCommonContentInfo>
  implements View.OnTouchListener
{
  private static final String d = "com.tencent.avgame.gamelobby.rv.AVGameLobbyCommonCellViewHolder";
  private AsyncImageView e;
  private AutoResizeAsyncImageView f;
  private View g;
  private LinearLayout h;
  private OverlappingImgLayout i;
  private TextView j;
  private IFaceDecoder k = null;
  
  public AVGameLobbyCommonCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.e = ((AsyncImageView)paramView.findViewById(2131429084));
    this.g = paramView.findViewById(2131429081);
    this.f = ((AutoResizeAsyncImageView)paramView.findViewById(2131429082));
    this.h = ((LinearLayout)paramView.findViewById(2131429079));
    this.i = ((OverlappingImgLayout)paramView.findViewById(2131429078));
    this.j = ((TextView)paramView.findViewById(2131429080));
    paramView.setOnTouchListener(this);
    a(paramView);
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (this.k == null) {
      this.k = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    }
  }
  
  protected void a()
  {
    IFaceDecoder localIFaceDecoder = this.k;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyCommonContentInfo paramAVGameLobbyCommonContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyCommonContentInfo, paramInt);
    if (paramAVGameLobbyCommonContentInfo == null) {
      return;
    }
    this.e.setUrlIconAsyncImage(paramAVGameLobbyCommonContentInfo.b);
    float f1 = ViewUtils.dip2px(6.0F);
    paramInt = paramAVGameLobbyCommonContentInfo.f;
    int m = paramAVGameLobbyCommonContentInfo.g;
    Object localObject = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt | 0xFF000000, 0xFF000000 | m });
    ((GradientDrawable)localObject).setCornerRadius(f1);
    ((GradientDrawable)localObject).setGradientType(0);
    this.g.setBackgroundDrawable((Drawable)localObject);
    localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApngImage url:");
    localStringBuilder.append(paramAVGameLobbyCommonContentInfo.c);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    this.f.a(paramAVGameLobbyCommonContentInfo.c);
    if ((paramViewHolderContext instanceof AVGameLobbyViewHolderContext)) {
      a(((AVGameLobbyViewHolderContext)paramViewHolderContext).a());
    }
    if (paramAVGameLobbyCommonContentInfo.e.size() > 0)
    {
      this.i.a(17, 17, paramAVGameLobbyCommonContentInfo.e, this.k);
      this.j.setText(paramAVGameLobbyCommonContentInfo.h);
      return;
    }
    this.h.setVisibility(8);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getActionMasked();
    if (m != 0)
    {
      if ((m == 1) || (m == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyCommonCellViewHolder
 * JD-Core Version:    0.7.0.1
 */