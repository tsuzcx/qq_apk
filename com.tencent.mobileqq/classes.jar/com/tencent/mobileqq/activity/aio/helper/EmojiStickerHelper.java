package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;

public class EmojiStickerHelper
  implements Handler.Callback, ILifeCycleHelper, AbsListView.OnScrollListener
{
  public View a;
  private final BaseChatPie b;
  
  public EmojiStickerHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  private void c()
  {
    EmojiStickerManager.a().a(this.b);
  }
  
  private void d()
  {
    EmojiStickerManager localEmojiStickerManager = EmojiStickerManager.a();
    BaseChatPie localBaseChatPie = this.b;
    localEmojiStickerManager.a(localBaseChatPie, localBaseChatPie.ah.b, this.b.ah.a, this.b.aD);
  }
  
  public void a()
  {
    ChatXListView localChatXListView = this.b.U;
    ChatAdapter1 localChatAdapter1 = this.b.V;
    if (localChatXListView != null)
    {
      Object localObject;
      if (localChatXListView.getChildCount() > 0)
      {
        int j = localChatXListView.getFirstVisiblePosition();
        localObject = localChatXListView.getChildAt(0);
        int i;
        if (localObject == null) {
          i = 0;
        } else {
          i = ((View)localObject).getTop();
        }
        localChatXListView.setSelectionFromTop(j, i);
      }
      if (this.a == null)
      {
        this.a = new View(this.b.e);
        this.a.setId(2131442203);
        localObject = new AbsListView.LayoutParams(-1, 80);
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.a.getParent() == null)
      {
        localChatXListView.setAdapter(null);
        localChatXListView.addFooterView(this.a, null, false);
        localChatXListView.setAdapter(localChatAdapter1);
        this.b.j(196608);
      }
    }
  }
  
  public void b()
  {
    ChatXListView localChatXListView = this.b.U;
    if ((this.a != null) && (localChatXListView != null))
    {
      if (localChatXListView.getChildCount() > 0)
      {
        int j = localChatXListView.getFirstVisiblePosition();
        int i = 0;
        localView = localChatXListView.getChildAt(0);
        if (localView != null) {
          i = localView.getTop();
        }
        localChatXListView.setSelectionFromTop(j, i);
      }
      View localView = this.a;
      if (localView != null) {
        localChatXListView.removeFooterView(localView);
      }
      this.a = null;
      this.b.j(196608);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "EmojiStickerHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 15) {
        return;
      }
      d();
      return;
    }
    c();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      EmojiStickerManager.a().b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.EmojiStickerHelper
 * JD-Core Version:    0.7.0.1
 */