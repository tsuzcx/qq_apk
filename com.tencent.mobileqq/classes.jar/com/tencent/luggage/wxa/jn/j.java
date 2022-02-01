package com.tencent.luggage.wxa.jn;

import com.tencent.luggage.wxa.jp.k;

public class j
  extends e
{
  private String f;
  
  public j(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    this.f = paramString3;
    paramString1 = new StringBuilder();
    paramString1.append("\"");
    paramString1.append(paramString2);
    paramString1.append("#");
    paramString1.append(this.b);
    paramString1.append("\"");
    a("SOAPACTION", paramString1.toString());
    c();
  }
  
  private String b(int paramInt, String paramString)
  {
    paramString = new k().a(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&lt;DIDL-Lite xmlns=&quot;urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/&quot; xmlns:upnp=&quot;urn:schemas-upnp-org:metadata-1-0/upnp/&quot; xmlns:dc=&quot;http://purl.org/dc/elements/1.1/&quot; xmlns:sec=&quot;http://www.sec.co.kr/&quot;&gt;&lt;item id=&quot;123&quot; parentID=&quot;-1&quot; restricted=&quot;1&quot;&gt;&lt;upnp:storageMedium&gt;UNKNOWN&lt;/upnp:storageMedium&gt;&lt;upnp:writeStatus&gt;UNKNOWN&lt;/upnp:writeStatus&gt;&lt;dc:title&gt;Video&lt;/dc:title&gt;&lt;dc:creator&gt;QGame&lt;/dc:creator&gt;&lt;upnp:class&gt;object.item.videoItem&lt;/upnp:class&gt;&lt;res protocolInfo=&quot;http-get:*:video/*:DLNA.ORG_OP=01;DLNA.ORG_CI=0;DLNA.ORG_FLAGS=01700000000000000000000000000000&quot;&gt;");
    ((StringBuilder)localObject).append(new k().a(paramString));
    ((StringBuilder)localObject).append("&lt;/res&gt;&lt;/item&gt;&lt;/DIDL-Lite&gt;");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<u:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" xmlns:u=\"");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\">\n<InstanceID>");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("</InstanceID>\n<CurrentURI>");
    localStringBuilder.append(paramString);
    localStringBuilder.append("</CurrentURI>\n<CurrentURIMetaData>");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("</CurrentURIMetaData>\n</u:SetAVTransportURI>\n");
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return "SetAVTransportURI";
  }
  
  public String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>");
    localStringBuilder.append(b(paramInt, paramString));
    localStringBuilder.append("</s:Body></s:Envelope>");
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return a(0, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jn.j
 * JD-Core Version:    0.7.0.1
 */