package com.tencent.biz.pubaccount.weishi_new.profile.presenter;

import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/WSRightPageProfilePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/AbsWSProfilePresenter;", "()V", "onPageSelected", "", "isSelectedByClickAvatar", "", "update", "person", "LUserGrowth/stSimpleMetaPerson;", "feedId", "", "updateFrom", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRightPageProfilePresenter
  extends AbsWSProfilePresenter
{
  private final void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = "click_avatar";
    } else {
      localObject = "slide_enter";
    }
    b((String)localObject);
    Object localObject = (WSProfileContract.View)getView();
    if (localObject != null) {
      ((WSProfileContract.View)localObject).c(g());
    }
  }
  
  public void a(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson, @Nullable String paramString)
  {
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    if (localView != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localView, "view ?: return");
      if (paramstSimpleMetaPerson != null)
      {
        CharSequence localCharSequence = (CharSequence)paramstSimpleMetaPerson.id;
        int i;
        if ((localCharSequence != null) && (!StringsKt.isBlank(localCharSequence))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          if (Intrinsics.areEqual(paramstSimpleMetaPerson.id, d()))
          {
            localView.a(paramString, true);
            return;
          }
          l();
          a(paramstSimpleMetaPerson);
          a(paramstSimpleMetaPerson, f());
          localView.a(paramString, false);
          return;
        }
      }
      l();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.presenter.WSRightPageProfilePresenter
 * JD-Core Version:    0.7.0.1
 */