package com.tencent.luggage.wxa.nv;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import java.util.List;

public final class d
{
  private static View a(Context paramContext, List<String> paramList, d.a parama)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131624226, null);
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(2131434377);
    localRecyclerView.setHasFixedSize(true);
    localRecyclerView.setLayoutManager(new GridLayoutManager(paramContext, 3));
    localRecyclerView.setAdapter(new d.b(paramList, parama));
    return localView;
  }
  
  public static void a(Context paramContext, boolean paramBoolean, List<String> paramList, String paramString, c paramc, d.a parama)
  {
    MMBottomSheet localMMBottomSheet = new MMBottomSheet(paramContext, false, 0);
    if (paramc.h_()) {
      localMMBottomSheet.setNewLandscapeMaxWidth((int)(paramc.getVDisplayMetrics().widthPixels * paramc.getScale()));
    }
    localMMBottomSheet.hideStatusBar(paramBoolean);
    localMMBottomSheet.hideNavigationFullScreen(paramBoolean);
    paramc = LayoutInflater.from(paramContext).inflate(2131624227, null);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)paramc.findViewById(16908310)).setText(paramString);
    }
    localMMBottomSheet.setFooterView(a(paramContext, paramList, new d.1(localMMBottomSheet, parama)));
    localMMBottomSheet.setTitleView(paramc, true);
    localMMBottomSheet.tryShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nv.d
 * JD-Core Version:    0.7.0.1
 */