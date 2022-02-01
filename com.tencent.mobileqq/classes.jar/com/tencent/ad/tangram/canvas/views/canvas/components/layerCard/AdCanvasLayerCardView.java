package com.tencent.ad.tangram.canvas.views.canvas.components.layerCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.Keep;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

@Keep
public class AdCanvasLayerCardView
  extends AdCanvasComponentView
  implements AdImageViewAdapter.Callback
{
  private static final String LAYER_CARD_MASK = "iVBORw0KGgoAAAANSUhEUgAAAAIAAAS0CAYAAABKatlfAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAAqADAAQAAAABAAAEtAAAAADpDgMIAAAEZklEQVRoBe2YDU4dQQyD36O9/2V6v1Jiab/F8mRmlsIKVUUqSvPj2JkEnng+Ho9fb/9eX+rbe+NRHn39fPteIXkwyvFqofJkDji/jxarHMOBGDgPa/olfNS0aGDA+dP50MKRXdfxFiQ3fLLKPTY6m/M53qPX5L2ggdHwUQtrepkPLWRQjmHP5DmESMbIkDxGtTzoYj5bfAzn+R7HGd7F53hT71683HMXH5tP0fDxQgOjUpyqPGOcrMpyzxnjLKo4kCfjTZz0kFwGNDAmuhZ8/s+nBtpP9bu91618xntoW3crn40ruJWPzcfGoo2y07vj3o1Pdc/fRP/+fGIIvMXsQ2Cs1u3vddf+fLf5/HhbUz7t1M6e71Uh+1Keea7/x3pR/iy3h46V0CbshkhGBYvExxVy8KQxyVmFpKnIwxmDUC0bOBgf40x5qsDT5EDM+FClgyUH8mUkIORfTDtn5Th1Be6Jqmwx4QNnqpKPPOIz7m66KBegheiVfLJKyaYUwAkOoZRDOYa3sF6OUyo8GV2EzKC741SLRimA0MBgEzJn0dS7kwwyBsjk4LEcADFS6XaIXrTAoDvaLZT7s93UcY4flatyqorPQHJ/F4nMAmzd+8Fw0HQSCj40FQ7jLV0eMqU7c/ZykMuQdgFu8DmTTRc4MgJnMl5XCg4CMQg1j2t8sqrK6YUK3ivnk5zxpAHO9RC64IwBZ7sven2MM+VJFU+TAzF7AiUXVf3plRx0ocJCkN+5r4bPosXkLlIpfJ5sbxmaPJ5jx7IcDwZjkUfaA+dsasg2KNe+yyeRB3yqqfUSVXtc5GA4Hz1B6Mrk5JM5eGRA7DqfY5gpGfLOR1M9ptHkrJbNmkLeqhBIC1dKsklGxaX7anqZ0iYHGqgwPlRN7gvOCGTgO/dOCx8UxMoYhPo9BBA+eBxH8+lxSEaOPPCBIaPDIDRJzpCqPsSnEZh8msfd2Gemkb1yPpmDJ41EJmcVYs4oxWC8dgW84GfcF93NaDhDrHmCxbvTonAY+NZ99cizOV+pgo9r370vaGDwTPJodMHHm9p8GhzlBI4n23ihgXHyOX6DUC7j8uNS7qMrqngapZbjxNj5zCnPpKmHSGZ7MSrkY8EznqEjG852aMFHOPYEMPyMe2eqRp5nQoUMcozPmdPvITkgswDnvVe5+PQ4lAOIMQj1OFkFH8fZ5ePlrI0/bvDJKohNPpxMQpBPZIWcz6V73/19ai0mfFBKDp40Jjmr0IKPetk+A5gzhBg5eDA8pP2JOXuOMWz4VM6le4f8eV9FY8xnslGNLnGOfSYZA6XJR57d+wIQQ8iiwXiDD00HybbP4Cx0pRyQMcSQH5UYtLBlQw4GLfBMXofkRmk1JecEZGLHSjQ5k3JCZQi5lILjfGzrmhxwyiDHOe+EwMnJ47EnUK+q+rr7auSM+ZySY58JwZnJM3DuXR5TSjlGQ6yZc/ChafJpWmgTAieTE3nQInCySsjMGV1l0PRT78t6qcVfPoGo/gFHAqOmRMO9vAAAAABJRU5ErkJggg==";
  private static final String NO_VIRUS_TAG = "iVBORw0KGgoAAAANSUhEUgAAABoAAAAgCAMAAAA7dZg3AAAAdVBMVEUAAACampqYmJiYmJiYmJicnJyYmJiXl5eXl5eampqYmJiYmJibm5uioqKYmJiXl5eYmJiYmJiampqXl5eYmJiZmZmYmJiYmJiampqampqfn5+YmJiYmJiZmZmYmJiYmJiYmJiYmJiXl5eZmZmenp6Xl5eXl5eBcAPkAAAAJnRSTlMAQcj49QXsz8Asn2wUCuDlr3wy2qh5ZVo7JRDx1Ey0nZCGVkYZUc+GMUUAAAEJSURBVCjPxdJXbsQgFEDRZ1ywPS5xn95z97/EIMQwTOL/3A8L+UgI0JOgQutCVtvEkGxW4HSEtgV9ko+KyQBjVY3AsSvcNkoNMSYViSlSmOJBqY3Y32SlBYtlhmWBsVv6VILSfulGMBTJStG/005/hRRKSx7Q3PmLFRm6CqjhK/Wi9hJQlDjrnXjytj2Q1/KijLu87C1yJxPNJM7yhLMTmVBSksvLOPuD5pTygJ2zpvSyg4ekrfE/lTTmO0O08oJ2tBTt81OeDcouigRdh1JrksKNIKjqLZWCbz+3MPTi6gcIZniJiW/27fY3s1wkaNvA4TLPlwSarXxUX2Ns8bWW31VdnmX59D7PD1RRHeX9vgF3AAAAAElFTkSuQmCC";
  private static final String STAR_DARK = "iVBORw0KGgoAAAANSUhEUgAAABwAAAAaCAYAAACkVDyJAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAHKADAAQAAAABAAAAGgAAAADr/QECAAACbElEQVRIDa2Wz2sTQRTHdzdGhIB66s2ChKhgr9oWBQ/Wu2cNSjQ/KOJBz6Wl0LMeRCE/NBqj5+JVj4pSz4K0iAf/ARWiQtjEzws7ZTaZ2WSSDkxn9r33/X73+3ZnU8+bYtRqtUsyp4B6h6YBgVmPcJdd8b4roNFoXAjD8L3gUqnUxWKx+MGFI3Apltper7ehMPpexcatTg7r9foSIh910iAIlkul0ic9lrR3cmhy1O/31fNM0tnPTeyQt/Ic5Dv7SG3j+/75crn8WQtZty4Ok5wk5WLiRofNZvNIt9vN4ihH9SnmGWYhhhy9aBL6ytzF8V46nf5WKBT+DZf57Xb7aKfTuU1CkecAnEDMeDPDBLZrOKDo/yC/x9yVNZPJPA3y+fxvkocJrDLlIM/PKgaHF3HMR5yrojHQkqSMarV6j+XB4OLg/9yvVCoPhTbWNs7ZHe7s0UE4HJDTVpzd5Zw+Vh5ighLk9S+xVGcVlWcIT4XjUhdeNUYEJUF7b7I8Y7ocG4Gq0WNziza+UAG1GgUlieg17rKF05QqnmQFE4K5gdhrU71VUIpp71vAKyagLYbgO9p4xZYf1zI58K4jEWN1SEuPofTTVS2qP05Lf5mwVof8uC6YAJPEkrBWQZ7d2UnITTVJ2CRBo0Neih0crMiUvUXQiJVa6z9R3GUMBPkXYmu8gduayCLP+iq5Ld3VMFartwtCsgDQY/0OYIPP0yv2cqBjg5djm7o3fBavk9hkf1KwsSLtwtjSVqs1BzAEKN/W07h6aRJTPJKTGqmNMKFwqLy+GlvKj+9firKQ/NGLx+1x26XmCW1+DofxC/UfzavsrjiuOakAAAAASUVORK5CYII=";
  private static final String STAR_LIGHT = "iVBORw0KGgoAAAANSUhEUgAAABwAAAAaCAYAAACkVDyJAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAHKADAAQAAAABAAAAGgAAAADr/QECAAACoElEQVRIDa1WTWgTURCeeU1Cs6H1Ip6qF0kRLPbiT6VCs6bem4gXhaqVKiIe9Fz1oGc9iAct/oLeTHpXmggtltqLB0EaxIM38RTJpjRmx5nQbdL1vU028cFm3/tmvu/beT+7AeiiVRczE3J1QYVINyQCuL3FS4flY1iCs5gdJ3CXhIegTlgnc8thNFSYZMklpDsep7XvYe3uoSp0CtkxIvdjqyiiOm7ZuZVWLKgfqkKCZnWeKGPeenpQ4L3jCivF7BFw3VWtmlJHE6ncJ23MB3ZeIQVUEhTzGWorpMKF/s3o7/1/apBEomGetgO8XS76uL4hPkfAr4S4HolCKVYb+Ib2iw1fEiCtnBusbjiX0MUkoTsMBEne73uJ+LeHhshKBD9YpYSk1klRKd5vPVU49rrMgZgL7lU2SfOh3termTynaGxppUVbPMRruwqnmLlBLt3voSgjFRXetFL5B5KwbSiDSiFzjWfi4f+osCHOYlzo9YSdfyRjaTsMBagWM7NE9LhXU1lDRLwST+XnRddr/xhKoFrInGfDZ7zqnR8bT5HvvFtdNpyJ2/mXLXCjqzWUSPVD9izV6RWb9vlJQWM2q2MfTscncm90eUZDSa4Upt7x7prUEY0YwvuEvXDKFA+cMn5aPvDhWjuO0ZDWzuzizTMUzk7OHw0J18QzGlbL9RETqR0exDUa8lf9YDthUzyIazTk3aStkNdoVUFkUi7p60xNXMk1/4lCHJH3RLPhF0A1Z9lvF5oYHKsUTk8Bufd49ZozIlxDM1bIVg0SH+DvSqlpyx49lNhp1pAUTGKSI7kCelydp/Yc0nJmj7MJn/nldNca3D2Ph5/UdGQ/RmuXo0751yx/J25ZMRjF8fxPf452TEszA0y2tMEOQOGKhi71LyUG6YhPH1qRAAAAAElFTkSuQmCC";
  private static final String TAG = "AdCanvasLayerCardView";
  private d adCanvasAppBtnComponentView;
  private com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b adCanvasImagesCarouselComponentView;
  private View logoView;
  private a value;
  
  public AdCanvasLayerCardView(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, Handler paramHandler)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama, paramHandler);
  }
  
  private void init(Context paramContext, a parama, Handler paramHandler)
  {
    if ((paramContext == null) || (parama == null) || (!parama.isValid())) {}
    for (;;)
    {
      return;
      this.value = parama;
      FrameLayout localFrameLayout = new FrameLayout(paramContext);
      parama = new FrameLayout.LayoutParams(this.value.width, -2);
      addView(localFrameLayout);
      localFrameLayout.setBackgroundColor(-16777216);
      localFrameLayout.setLayoutParams(parama);
      this.adCanvasImagesCarouselComponentView = new com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b(paramContext, this.canvasViewListener, this.value.adCanvasImagesCarouselComponentData, paramHandler);
      parama = new FrameLayout.LayoutParams(this.value.width, this.value.height);
      localFrameLayout.addView(this.adCanvasImagesCarouselComponentView, parama);
      parama = new ImageView(paramContext);
      paramHandler = new FrameLayout.LayoutParams(-1, -1);
      parama.setLayoutParams(paramHandler);
      Object localObject1 = AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAAAIAAAS0CAYAAABKatlfAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAAqADAAQAAAABAAAEtAAAAADpDgMIAAAEZklEQVRoBe2YDU4dQQyD36O9/2V6v1Jiab/F8mRmlsIKVUUqSvPj2JkEnng+Ho9fb/9eX+rbe+NRHn39fPteIXkwyvFqofJkDji/jxarHMOBGDgPa/olfNS0aGDA+dP50MKRXdfxFiQ3fLLKPTY6m/M53qPX5L2ggdHwUQtrepkPLWRQjmHP5DmESMbIkDxGtTzoYj5bfAzn+R7HGd7F53hT71683HMXH5tP0fDxQgOjUpyqPGOcrMpyzxnjLKo4kCfjTZz0kFwGNDAmuhZ8/s+nBtpP9bu91618xntoW3crn40ruJWPzcfGoo2y07vj3o1Pdc/fRP/+fGIIvMXsQ2Cs1u3vddf+fLf5/HhbUz7t1M6e71Uh+1Keea7/x3pR/iy3h46V0CbshkhGBYvExxVy8KQxyVmFpKnIwxmDUC0bOBgf40x5qsDT5EDM+FClgyUH8mUkIORfTDtn5Th1Be6Jqmwx4QNnqpKPPOIz7m66KBegheiVfLJKyaYUwAkOoZRDOYa3sF6OUyo8GV2EzKC741SLRimA0MBgEzJn0dS7kwwyBsjk4LEcADFS6XaIXrTAoDvaLZT7s93UcY4flatyqorPQHJ/F4nMAmzd+8Fw0HQSCj40FQ7jLV0eMqU7c/ZykMuQdgFu8DmTTRc4MgJnMl5XCg4CMQg1j2t8sqrK6YUK3ivnk5zxpAHO9RC64IwBZ7sven2MM+VJFU+TAzF7AiUXVf3plRx0ocJCkN+5r4bPosXkLlIpfJ5sbxmaPJ5jx7IcDwZjkUfaA+dsasg2KNe+yyeRB3yqqfUSVXtc5GA4Hz1B6Mrk5JM5eGRA7DqfY5gpGfLOR1M9ptHkrJbNmkLeqhBIC1dKsklGxaX7anqZ0iYHGqgwPlRN7gvOCGTgO/dOCx8UxMoYhPo9BBA+eBxH8+lxSEaOPPCBIaPDIDRJzpCqPsSnEZh8msfd2Gemkb1yPpmDJ41EJmcVYs4oxWC8dgW84GfcF93NaDhDrHmCxbvTonAY+NZ99cizOV+pgo9r370vaGDwTPJodMHHm9p8GhzlBI4n23ihgXHyOX6DUC7j8uNS7qMrqngapZbjxNj5zCnPpKmHSGZ7MSrkY8EznqEjG852aMFHOPYEMPyMe2eqRp5nQoUMcozPmdPvITkgswDnvVe5+PQ4lAOIMQj1OFkFH8fZ5ePlrI0/bvDJKohNPpxMQpBPZIWcz6V73/19ai0mfFBKDp40Jjmr0IKPetk+A5gzhBg5eDA8pP2JOXuOMWz4VM6le4f8eV9FY8xnslGNLnGOfSYZA6XJR57d+wIQQ8iiwXiDD00HybbP4Cx0pRyQMcSQH5UYtLBlQw4GLfBMXofkRmk1JecEZGLHSjQ5k3JCZQi5lILjfGzrmhxwyiDHOe+EwMnJ47EnUK+q+rr7auSM+ZySY58JwZnJM3DuXR5TSjlGQ6yZc/ChafJpWmgTAieTE3nQInCySsjMGV1l0PRT78t6qcVfPoGo/gFHAqOmRMO9vAAAAABJRU5ErkJggg==");
      if (localObject1 != null) {
        parama.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
      }
      localFrameLayout.addView(parama, paramHandler);
      paramHandler = new RelativeLayout(paramContext);
      paramHandler.setId(4369);
      paramHandler.setPadding(AdUIUtils.dp2px(20.0F, paramContext.getResources()), AdUIUtils.dp2px(42.0F, paramContext.getResources()), AdUIUtils.dp2px(20.0F, paramContext.getResources()), AdUIUtils.dp2px(20.0F, paramContext.getResources()));
      parama = new FrameLayout.LayoutParams(-1, -2);
      parama.gravity = 80;
      parama.leftMargin = AdUIUtils.dp2px(24.0F, paramContext.getResources());
      parama.rightMargin = AdUIUtils.dp2px(24.0F, paramContext.getResources());
      parama.bottomMargin = AdUIUtils.dp2px(72.0F, paramContext.getResources());
      paramHandler.setBackgroundColor(Color.parseColor("#DEDDDE"));
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setShape(0);
      ((GradientDrawable)localObject1).setCornerRadius(AdUIUtils.dp2px(10.0F, paramContext.getResources()));
      ((GradientDrawable)localObject1).setAlpha(216);
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#DEDDDE"));
      if (Build.VERSION.SDK_INT >= 16) {
        paramHandler.setBackground((Drawable)localObject1);
      }
      for (;;)
      {
        localFrameLayout.addView(paramHandler);
        paramHandler.setLayoutParams(parama);
        parama = new AdImageViewAdapter.Params();
        parama.context = new WeakReference(paramContext);
        parama.url = this.value.logoUrl;
        parama.callback = new WeakReference(this);
        this.logoView = AdImageViewBuilder.buildImageView(parama);
        if (this.logoView != null) {
          break;
        }
        AdLog.e("AdCanvasLayerCardView", "buildImageView Failed");
        stopLoad(false);
        return;
        paramHandler.setBackgroundDrawable((Drawable)localObject1);
      }
      this.logoView.setId(8738);
      paramHandler.addView(this.logoView);
      parama = this.logoView.getLayoutParams();
      parama.width = this.value.logoWidth;
      parama.height = this.value.logoHeight;
      this.logoView.setLayoutParams(parama);
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setId(13107);
      ((TextView)localObject1).setText(this.value.appName);
      ((TextView)localObject1).setTextSize(15.0F);
      ((TextView)localObject1).setMaxLines(1);
      ((TextView)localObject1).setTextColor(Color.parseColor("#000000"));
      ((TextView)localObject1).setMaxWidth(AdUIUtils.dp2px(170.0F, paramContext.getResources()));
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).getPaint().setFakeBoldText(true);
      paramHandler.addView((View)localObject1);
      parama = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      parama.addRule(1, this.logoView.getId());
      parama.leftMargin = AdUIUtils.dp2px(12.0F, paramContext.getResources());
      parama.topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
      Object localObject2 = new LinearLayout(paramContext);
      ((LinearLayout)localObject2).setOrientation(0);
      parama = new LinearLayout.LayoutParams(AdUIUtils.dp2px(12.0F, paramContext.getResources()), AdUIUtils.dp2px(12.0F, paramContext.getResources()));
      parama.leftMargin = AdUIUtils.dp2px(3.0F, paramContext.getResources());
      parama.topMargin = AdUIUtils.dp2px(5.0F, paramContext.getResources());
      int j = Math.min(this.value.starCount, 5);
      int i = 0;
      while (i < j)
      {
        localObject3 = new ImageView(paramContext);
        ((ImageView)localObject3).setImageBitmap(AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAABwAAAAaCAYAAACkVDyJAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAHKADAAQAAAABAAAAGgAAAADr/QECAAACoElEQVRIDa1WTWgTURCeeU1Cs6H1Ip6qF0kRLPbiT6VCs6bem4gXhaqVKiIe9Fz1oGc9iAct/oLeTHpXmggtltqLB0EaxIM38RTJpjRmx5nQbdL1vU028cFm3/tmvu/beT+7AeiiVRczE3J1QYVINyQCuL3FS4flY1iCs5gdJ3CXhIegTlgnc8thNFSYZMklpDsep7XvYe3uoSp0CtkxIvdjqyiiOm7ZuZVWLKgfqkKCZnWeKGPeenpQ4L3jCivF7BFw3VWtmlJHE6ncJ23MB3ZeIQVUEhTzGWorpMKF/s3o7/1/apBEomGetgO8XS76uL4hPkfAr4S4HolCKVYb+Ib2iw1fEiCtnBusbjiX0MUkoTsMBEne73uJ+LeHhshKBD9YpYSk1klRKd5vPVU49rrMgZgL7lU2SfOh3termTynaGxppUVbPMRruwqnmLlBLt3voSgjFRXetFL5B5KwbSiDSiFzjWfi4f+osCHOYlzo9YSdfyRjaTsMBagWM7NE9LhXU1lDRLwST+XnRddr/xhKoFrInGfDZ7zqnR8bT5HvvFtdNpyJ2/mXLXCjqzWUSPVD9izV6RWb9vlJQWM2q2MfTscncm90eUZDSa4Upt7x7prUEY0YwvuEvXDKFA+cMn5aPvDhWjuO0ZDWzuzizTMUzk7OHw0J18QzGlbL9RETqR0exDUa8lf9YDthUzyIazTk3aStkNdoVUFkUi7p60xNXMk1/4lCHJH3RLPhF0A1Z9lvF5oYHKsUTk8Bufd49ZozIlxDM1bIVg0SH+DvSqlpyx49lNhp1pAUTGKSI7kCelydp/Yc0nJmj7MJn/nldNca3D2Ph5/UdGQ/RmuXo0751yx/J25ZMRjF8fxPf452TEszA0y2tMEOQOGKhi71LyUG6YhPH1qRAAAAAElFTkSuQmCC"));
        ((LinearLayout)localObject2).addView((View)localObject3, parama);
        i += 1;
      }
      i = 0;
      while (i < 5 - j)
      {
        localObject3 = new ImageView(paramContext);
        ((ImageView)localObject3).setImageBitmap(AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAABwAAAAaCAYAAACkVDyJAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAHKADAAQAAAABAAAAGgAAAADr/QECAAACbElEQVRIDa2Wz2sTQRTHdzdGhIB66s2ChKhgr9oWBQ/Wu2cNSjQ/KOJBz6Wl0LMeRCE/NBqj5+JVj4pSz4K0iAf/ARWiQtjEzws7ZTaZ2WSSDkxn9r33/X73+3ZnU8+bYtRqtUsyp4B6h6YBgVmPcJdd8b4roNFoXAjD8L3gUqnUxWKx+MGFI3Apltper7ehMPpexcatTg7r9foSIh910iAIlkul0ic9lrR3cmhy1O/31fNM0tnPTeyQt/Ic5Dv7SG3j+/75crn8WQtZty4Ok5wk5WLiRofNZvNIt9vN4ihH9SnmGWYhhhy9aBL6ytzF8V46nf5WKBT+DZf57Xb7aKfTuU1CkecAnEDMeDPDBLZrOKDo/yC/x9yVNZPJPA3y+fxvkocJrDLlIM/PKgaHF3HMR5yrojHQkqSMarV6j+XB4OLg/9yvVCoPhTbWNs7ZHe7s0UE4HJDTVpzd5Zw+Vh5ighLk9S+xVGcVlWcIT4XjUhdeNUYEJUF7b7I8Y7ocG4Gq0WNziza+UAG1GgUlieg17rKF05QqnmQFE4K5gdhrU71VUIpp71vAKyagLYbgO9p4xZYf1zI58K4jEWN1SEuPofTTVS2qP05Lf5mwVof8uC6YAJPEkrBWQZ7d2UnITTVJ2CRBo0Neih0crMiUvUXQiJVa6z9R3GUMBPkXYmu8gduayCLP+iq5Ld3VMFartwtCsgDQY/0OYIPP0yv2cqBjg5djm7o3fBavk9hkf1KwsSLtwtjSVqs1BzAEKN/W07h6aRJTPJKTGqmNMKFwqLy+GlvKj+9firKQ/NGLx+1x26XmCW1+DofxC/UfzavsrjiuOakAAAAASUVORK5CYII="));
        ((LinearLayout)localObject2).addView((View)localObject3, parama);
        i += 1;
      }
      Object localObject3 = new TextView(paramContext);
      ((TextView)localObject3).setMaxWidth(AdUIUtils.dp2px(120.0F, paramContext.getResources()));
      parama = "";
      if (this.value.downloadCount != 0L) {
        parama = "(" + AdUIUtils.formatNumberToChineseUnit(this.value.downloadCount) + ")";
      }
      ((TextView)localObject3).setText(parama);
      ((TextView)localObject3).setMaxLines(1);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject3).setTextColor(Color.parseColor("#000000"));
      ((TextView)localObject3).setTextSize(15.0F);
      parama = new LinearLayout.LayoutParams(-2, -2);
      parama.leftMargin = AdUIUtils.dp2px(3.0F, paramContext.getResources());
      ((LinearLayout)localObject2).addView((View)localObject3, parama);
      parama = new RelativeLayout.LayoutParams(-2, -2);
      parama.addRule(1, this.logoView.getId());
      parama.addRule(3, ((TextView)localObject1).getId());
      parama.leftMargin = AdUIUtils.dp2px(12.0F, paramContext.getResources());
      parama.topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
      paramHandler.addView((View)localObject2, parama);
      parama = new TextView(paramContext);
      parama.setId(17476);
      parama.setText(this.value.appDesc);
      parama.setTextSize(14.0F);
      parama.setTextColor(Color.parseColor("#000000"));
      parama.setMaxLines(3);
      parama.setEllipsize(TextUtils.TruncateAt.END);
      paramHandler.addView(parama);
      localObject1 = (RelativeLayout.LayoutParams)parama.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.logoView.getId());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = AdUIUtils.dp2px(20.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AdUIUtils.dp2px(20.0F, paramContext.getResources());
      localObject1 = new RelativeLayout(paramContext);
      ((RelativeLayout)localObject1).setId(21845);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, parama.getId());
      paramHandler.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.adCanvasAppBtnComponentView = new d(paramContext, this.canvasViewListener, this.value.adCanvasAppBtnComponentData, true);
      parama = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).addView(this.adCanvasAppBtnComponentView, parama);
      parama = new LinearLayout(paramContext);
      parama.setOrientation(0);
      parama.setGravity(1);
      paramHandler = new FrameLayout.LayoutParams(-1, -2);
      paramHandler.gravity = 80;
      paramHandler.bottomMargin = AdUIUtils.dp2px(30.0F, paramContext.getResources());
      localFrameLayout.addView(parama, paramHandler);
      paramHandler = new String[3];
      paramHandler[0] = "无广告";
      paramHandler[1] = "无病毒";
      paramHandler[2] = "有保障";
      i = 0;
      while (i < paramHandler.length)
      {
        localFrameLayout = paramHandler[i];
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setImageBitmap(AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAABoAAAAgCAMAAAA7dZg3AAAAdVBMVEUAAACampqYmJiYmJiYmJicnJyYmJiXl5eXl5eampqYmJiYmJibm5uioqKYmJiXl5eYmJiYmJiampqXl5eYmJiZmZmYmJiYmJiampqampqfn5+YmJiYmJiZmZmYmJiYmJiYmJiYmJiXl5eZmZmenp6Xl5eXl5eBcAPkAAAAJnRSTlMAQcj49QXsz8Asn2wUCuDlr3wy2qh5ZVo7JRDx1Ey0nZCGVkYZUc+GMUUAAAEJSURBVCjPxdJXbsQgFEDRZ1ywPS5xn95z97/EIMQwTOL/3A8L+UgI0JOgQutCVtvEkGxW4HSEtgV9ko+KyQBjVY3AsSvcNkoNMSYViSlSmOJBqY3Y32SlBYtlhmWBsVv6VILSfulGMBTJStG/005/hRRKSx7Q3PmLFRm6CqjhK/Wi9hJQlDjrnXjytj2Q1/KijLu87C1yJxPNJM7yhLMTmVBSksvLOPuD5pTygJ2zpvSyg4ekrfE/lTTmO0O08oJ2tBTt81OeDcouigRdh1JrksKNIKjqLZWCbz+3MPTi6gcIZniJiW/27fY3s1wkaNvA4TLPlwSarXxUX2Ns8bWW31VdnmX59D7PD1RRHeX9vgF3AAAAAElFTkSuQmCC"));
        localObject2 = new LinearLayout.LayoutParams(AdUIUtils.dp2px(16.0F, paramContext.getResources()), AdUIUtils.dp2px(16.0F, paramContext.getResources()));
        if (i > 0) {
          ((LinearLayout.LayoutParams)localObject2).leftMargin = AdUIUtils.dp2px(25.0F, paramContext.getResources());
        }
        ((LinearLayout.LayoutParams)localObject2).rightMargin = AdUIUtils.dp2px(5.0F, paramContext.getResources());
        parama.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setText(localFrameLayout);
        ((TextView)localObject1).setTextSize(13.0F);
        ((TextView)localObject1).setTextColor(Color.parseColor("#676363"));
        parama.addView((View)localObject1);
        i += 1;
      }
    }
  }
  
  public com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b getAdCanvasImagesCarouselComponentView()
  {
    return this.adCanvasImagesCarouselComponentView;
  }
  
  public AdCanvasComponentData getData()
  {
    return this.value;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onLocationChanged()
  {
    super.onLocationChanged();
    if ((this.adCanvasImagesCarouselComponentView != null) && (this.adCanvasImagesCarouselComponentView.getAdCanvasPictureComponentViews() != null))
    {
      Iterator localIterator = this.adCanvasImagesCarouselComponentView.getAdCanvasPictureComponentViews().iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)localIterator.next()).onLocationChanged();
      }
    }
  }
  
  public void onStopLoad(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.layerCard.AdCanvasLayerCardView
 * JD-Core Version:    0.7.0.1
 */