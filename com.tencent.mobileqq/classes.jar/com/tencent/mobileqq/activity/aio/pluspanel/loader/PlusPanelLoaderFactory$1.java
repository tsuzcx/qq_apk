package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.BusinessCRMEXTPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.CircleGroupStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.ContactStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.DateStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.GroupOrDiscussionStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.MovieTicketStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.NearByStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.TribeStrangerPlusPanelAppLoader;

class PlusPanelLoaderFactory$1
  extends SparseArray<Class<? extends PlusPanelAppLoader>>
{
  PlusPanelLoaderFactory$1(PlusPanelLoaderFactory paramPlusPanelLoaderFactory)
  {
    put(1000, GroupOrDiscussionStrangerPlusPanelAppLoader.class);
    put(1004, GroupOrDiscussionStrangerPlusPanelAppLoader.class);
    put(1008, PublicAccountPlusPanelAppLoader.class);
    put(1024, PublicAccountPlusPanelAppLoader.class);
    put(1020, CommonPlusPanelAppLoader.class);
    put(1005, CommonPlusPanelAppLoader.class);
    put(1003, CommonPlusPanelAppLoader.class);
    put(1022, CommonPlusPanelAppLoader.class);
    put(1009, CommonPlusPanelAppLoader.class);
    put(1023, CommonPlusPanelAppLoader.class);
    put(3000, DiscussPlusPanelAppLoader.class);
    put(10004, MovieTicketStrangerPlusPanelAppLoader.class);
    put(1006, ContactStrangerPlusPanelAppLoader.class);
    put(1025, BusinessCRMEXTPlusPanelAppLoader.class);
    put(1001, NearByStrangerPlusPanelAppLoader.class);
    put(10002, TribeStrangerPlusPanelAppLoader.class);
    put(1010, DateStrangerPlusPanelAppLoader.class);
    put(1021, CircleGroupStrangerPlusPanelAppLoader.class);
    put(6000, DataLinePCPlusPanelAppLoader.class);
    put(9501, DevicePlusPanelAppLoader.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelLoaderFactory.1
 * JD-Core Version:    0.7.0.1
 */