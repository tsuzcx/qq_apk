package com.tencent.luggage.wxa.aw;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class a
  implements b
{
  public void a(String paramString, ImageView paramImageView, c paramc)
  {
    if (paramc == c.a) {
      paramImageView.setImageResource(2130853688);
    } else {
      paramImageView.setImageResource(2130853693);
    }
    Glide.b(paramImageView.getContext()).a(paramString).a(DrawableTransitionOptions.c()).a(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aw.a
 * JD-Core Version:    0.7.0.1
 */