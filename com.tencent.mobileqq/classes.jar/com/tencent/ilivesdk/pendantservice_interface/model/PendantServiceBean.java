package com.tencent.ilivesdk.pendantservice_interface.model;

import java.util.ArrayList;

public class PendantServiceBean
{
  public static final int PIC_URL_NUM_TYPE = 3;
  public static final int PIC_URL_TYPE = 2;
  public static final int UNKOWN_DEFAULT_TYPE = 0;
  public static final int UNVISIBLE = 0;
  public static final int VISIBLE = 1;
  public static final int WEBVIEW_TYPE = 1;
  public String businessData;
  public long maxUpdateDuration;
  public String meta;
  public long minUpdateDuration;
  public ArrayList<PicPendantBean> picInfos = new ArrayList();
  public String version;
  public long viewId;
  public long viewType;
  public long visible;
  public WebPendantBean webPendantBean;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pendantservice_interface.model.PendantServiceBean
 * JD-Core Version:    0.7.0.1
 */